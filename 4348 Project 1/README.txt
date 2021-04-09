Files in fxs180012_Project1.zip:
src
- contains source codes
- main.cpp
- Memory.cpp
- Memory.hpp

Sample Files
- sample1 - 4.txt
- sample5.txt (the sample file I created)
	Sample5.txt output:
	     /\
	____/  \____
	\          /
	 \        /
	 /        \
	/___    ___\
	    \  /
	     \/

4348 Project 1 Summary
- Word document that summarizes the project 1

Compiling instructions:

If using cs1linux1:
1) log in to cs1.utdallas.edu using netID and password
2) Transfer sample files and src files into remote server
3) Type:
	g++ -c -std=c++11 main.cpp Memory.cpp [Press Enter]
	g++ -o main main.o Memory.o [Press Enter]
	./main <sampleX.txt> <timer_value>
		- The X stands for the sample no. you want to test for
       		 - timer_value is a number you want as the timer value for timer interruption
4) Code should run and output should show


If using terminal on Mac:
1) Open up terminal
2) Type:
    - g++ -c main.cpp Memory.cpp
    - g++ -o main main.o Memory.o
    - ./main <sampleX.txt> <timer_value>
	- The X stands for the sample no. you want to test for
        - timer_value is a number you want as the timer value for timer interruption
3) The code should run and the output should show