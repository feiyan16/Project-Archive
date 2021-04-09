//
//  Memory.cpp
//  os_sim
//
//  Created by Feiyan Su on 2/26/21.
//

#include "Memory.hpp"

Memory::Memory(string user_prog, int addr) {
    
    // set member attributes;
    address = addr;
    
    // line from textfile;
    string line;
    
    // instruction from textfile after parsed;
    int instruction;
    
    // open file
    ifstream input(user_prog.c_str());
    
    // if file couldn't be opened/found/etc.;
    if(!input) {
        cout << "Error with file" << endl;
        exit(0);
    }
    
    // while not end of file;
    while(!input.eof()) {
        
        // store each line of textfile into line;
        getline(input, line);
        
        // if line is empty, go to next line;
        if (line.length() == 0) { continue; }
        
        // get parsed instruction;
        instruction = get_instr(line);
        
        // check to see if instruction is new load address
        if ((address == instruction && line[0] == '.') || instruction == -1) { continue; };
        
        // assign instruction to memory at the relevant address;
        memory[address] = instruction;
        
        // increment address as you go to next line to go to next array index;
        address++;
    }
}

// read element from memory array at index addr
int Memory::read(int addr) {
    
    // check for memory violation
    if (usr_mode && addr >= 1000) {
        cout << "Memory violation: accessing system address " << addr << " in user mode" << endl;
    }
    
    value = memory[addr];
    return value;
}

// write val to memory array at index addr
void Memory::write(int addr, int val) {
    memory[addr] = val;
}

// set user mode
void Memory::set_usr_mode(bool mode) {
    usr_mode = mode;
}

// function to parse instructions
int Memory::get_instr(string str) {
    
    // instruction as a string
    string instr_str;
    
    // to check if integer is a new load address
    bool is_new_addr = false;
    
    // start of substring; end of substring; instructuction as an integer
    int start = 0; int end = (int) str.find(" "); int instr_int;
    
    // check if str is an empty string
    if(isspace(str[0])) { return -1; };
    
    // check for new load address
    if(str[0] == '.') {
        start = 1;
        is_new_addr = true;
    };
    
    // get instruction without comments/etc.
    instr_str = str.substr(start, end);
    
    // convert from string to int
    istringstream convert(instr_str);
    convert >> instr_int;
    
    // if str is new load address, then assign address to istr_int
    if (is_new_addr == true) { address = instr_int; };
    
    return instr_int;
}
