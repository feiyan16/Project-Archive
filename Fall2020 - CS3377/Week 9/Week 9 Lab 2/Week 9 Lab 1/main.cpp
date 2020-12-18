//
//  main.cpp
//  Week 9 Lab 1
//
//  Created by Feiyan on 10/13/20.
//

#include <iostream>
#include <unistd.h>
#include <stdio.h>

int main(void) {
    
    pid_t pid, pid2;

//    fork();
//    std::cout << "This is process PID: " << (long)getpid() << std::endl;
    
//    fork(); fork();
//    std::cout << "This is process PID: " << (long)getpid() << std::endl;

//    fork(); fork(); fork();
//    std::cout << "This is process PID: " << (long)getpid() << std::endl;

    if ((pid = fork()) && (pid2 = fork())) { fork(); }
    if ((pid = fork()) && (pid2 = fork())) { fork(); }
    if ((pid = fork()) && (pid2 = fork())) { fork(); }
    std::cout << "Process PID = " << (long)getpid() << std::endl;
//    std::cout << "pid = " << pid << " " << "pid2 = " << pid2 << std::endl;

//    for (int i = 1; i <= 5; i++) {
//        fork();
//    }
//    std::cout << "Process PID = " << (long)getpid() << std::endl;
    
    return 0;
}
