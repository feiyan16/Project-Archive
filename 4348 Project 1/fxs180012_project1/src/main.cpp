//
//  main.cpp
//  pipe_t
//
//  Created by Feiyan on 2/21/21.
//

#include <iostream>
#include <unistd.h>
#include "Memory.hpp"
using namespace std;

static void cpu_exec(int &AC, int IR, Memory &M, int &PC, int &SP, int &X, int &Y, bool &cpu_is_on, int *stack, bool &usr_mode, bool &sys_call, bool &timer_int);


int main(int argc, const char * argv[]) {
    
    // file descriptors; program stack
    int m_c[2], c_m[2]; int stack[2000];
    
    // pid for forking
    pid_t pid;
    
    // cpu registers
    int AC = 0; int IR = 0; int PC = 0; int SP = 999; int X = 0; int Y = 0;
    
    // boolean for while loop ctrl, check if program is in usr_mode, check if a system call is made, check if there's a timer interruption
    bool cpu_is_on = false, usr_mode = true, sys_call = false, timer_int = false;
    
    // program enetered
    string program;
    
    // timer input, timer counter
    int timer = 0, tmr_ctr = 0;
    
/*
 *    check for terminal input
 *    if 1 arg then program and timer value not entered
 *    if 2 arg then only program is entered
 *    if 3 then input is enetered correctly, and turn on the cpu
 */
    if (argc == 1) {
        cout << "Please enter program" << endl;
        return 0;
    } else if (argc == 2) {
        cout << "please enter a timer value" << endl;
    } else if (argc == 3) {
        program = argv[1];
        timer = stoi(argv[2]);
        cpu_is_on = true;
    }
    
    // read input file and save instruction to memory array
    Memory M = *new Memory(program, 0);
    
    // pipe file descriptors and check for error
    if(pipe(m_c) == -1 || pipe(c_m) == -1) { exit(0); }

    // fork process
    pid = fork();

    // if error when forking, exit
    if (pid < 0) { exit(0); }

    // communicate between cpu and memory while cpu_is_on == true
    while (cpu_is_on) {

        if (pid == 0) {

            // set IR to value read from memory
            IR = M.read(PC);

            // write IR at PC to child
            if (write(m_c[1], &IR, sizeof(IR)) == -1) { return 0; }

            // read updated PC from child
            if (read(c_m[0], &PC, sizeof(PC)) == -1) { return 0; }

        } else if (pid > 0) {
            
            // read instruction from parent
            if (read(m_c[0], &IR, sizeof(IR)) == -1) { return 0; }

            // check timer interruption
            if(tmr_ctr == timer) {
                
                // reset timer counter to 0
                tmr_ctr = 0;
                
                if(!sys_call && !timer_int) {

                    // set usr_mode to false; set timer_int to true
                    usr_mode = false; timer_int = true;

                    // save current stack ptr and set it to 1999
                    int sp = SP; SP = 1999;

                    // save sp to the stack at 1999
                    stack[SP] = sp; SP--;

                    // save PC to the stack at 1998
                    stack[SP] = PC - 1; SP--;
                    
                    // set PC to execution at 1000
                    PC = 1000;
                }
            } else {

                // set user mode
                M.set_usr_mode(usr_mode);

                // execute instructions then increment program counter
                cpu_exec(AC, IR, M, PC, SP, X, Y, cpu_is_on, stack, usr_mode, sys_call, timer_int);
                PC++;
            }
            // increment timer counter
            tmr_ctr++;

            // write updated PC back to parent
            if (write(c_m[1], &PC, sizeof(PC)) == -1) { return 0; }
        }
    }
    
    return 0;
}

static void cpu_exec(int &AC, int IR, Memory &M, int &PC, int &SP, int &X, int &Y, bool &cpu_is_on, int *stack, bool &usr_mode, bool &sys_call, bool &timer_int) {
    
    if (IR == 1) {
        PC++;
        AC = M.read(PC);
    } else if (IR == 2) {
        PC++;
        int addr = M.read(PC);
        AC = M.read(addr);
    } else if (IR == 3) {
        PC++;
        int ptr = M.read(PC);
        int addr = M.read(ptr);
        AC = M.read(addr);
    } else if (IR == 4) {
        PC++;
        int addr = M.read(PC) + X;
        AC = M.read(addr);
    } else if (IR == 5) {
        PC++;
        int addr = M.read(PC) + Y;
        AC = M.read(addr);
    } else if (IR == 6) {
        int n_sp = SP + X + 1;
        AC = stack[n_sp];
    } else if (IR == 7) {
        PC++;
        int addr = M.read(PC);
        M.write(addr, AC);
    } else if (IR == 8) {
        AC = rand() % 100 + 1;
    } else if (IR == 9) {
        PC++;
        int port = M.read(PC);
        if (port == 1) {
            cout << AC;
        } else if (port == 2) {
            cout << (char)AC;
        }
    } else if (IR == 10) {
        AC += X;
    } else if (IR == 11) {
        AC += Y;
    } else if (IR == 12) {
        AC -= X;
    } else if (IR == 13) {
        AC -= Y;
    } else if (IR == 14) {
        X = AC;
    } else if (IR == 15) {
        AC = X;
    } else if (IR == 16) {
        Y = AC;
    } else if (IR == 17) {
        AC = Y;
    } else if (IR == 18) {
        SP = AC;
    } else if (IR == 19) {
        AC = SP;
    } else if (IR == 20) {
        PC++;
        int addr = M.read(PC) - 1;
        PC = addr;
    } else if (IR == 21) {
        PC++;
        if (AC == 0) {
            int addr = M.read(PC) - 1;
            PC = addr;
        }
    } else if (IR == 22) {
        PC++;
        if (AC != 0) {
            int addr = M.read(PC) - 1;
            PC = addr;
        }
    } else if (IR == 23){
        stack[SP] = PC;
        SP--; PC++;
        int addr = M.read(PC) - 1;
        PC = addr;
    } else if (IR == 24) {
        SP++;
        PC = stack[SP] + 1;
    } else if (IR == 25) {
        X++;
    } else if (IR == 26) {
        X--;
    } else if (IR == 27) {
        stack[SP] = AC;
        SP--;
    } else if (IR == 28) {
        SP++;
        AC = stack[SP];
    } else if (IR == 29) {
        sys_call = true;
        usr_mode = false;
        int sp = SP;
        SP = 1999;
        stack[SP] = sp; SP--;
        stack[SP] = PC; SP--;
        PC = 1499;
    } else if (IR == 30) {
        SP++; PC = stack[SP];
        SP++; SP = stack[SP];
        usr_mode = true;
        if (sys_call) { sys_call = false; }
        if (timer_int) { timer_int = false; }
    } else if (IR == 50) {
        cpu_is_on = false;
        exit(0);
    }
}
