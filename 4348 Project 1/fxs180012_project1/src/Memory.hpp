//
//  Memory.hpp
//  os_sim
//
//  Created by Feiyan Su on 2/26/21.
//

#ifndef Memory_hpp
#define Memory_hpp

#include <stdio.h>
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <ctype.h>
using namespace std;

class Memory {
    
private:
    int memory[2000];
    int value, address;
    bool usr_mode;
    
public:
    int pc; 
    Memory(string user_prog, int addr);
    int read(int addr);
    void write(int addr, int val);
    void set_usr_mode(bool mode);
    int get_instr(string str);
};

#endif /* Memory_hpp */
