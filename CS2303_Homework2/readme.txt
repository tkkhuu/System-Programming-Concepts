Name: Tri Khuu:
Username: tkkhuu

LIST OF FILES
at.c			- contains the source code for lab 2
at2.c			- contains source code for obtaining values from the command
			line and store it into an array, then sort it and print it
at3.c 			- contains source code for filling in an array with random 				numbers, then print it, then sort it, then print it again
sort_arrays.c		- contains function that can sort an arrays, generate an random 			integer, fill an array with random numbers
print_arrays.c		- contains functions that can print an array of type integers and 			doubles, and get the integer from the command line and store it 			into an array
sort_array.h		- contains the function prototypes defined in sort_arrays.c
print_array.h		- contains the function prototypes defined in sort_arrays.c
Doxyfile		- contains the information to create the doxygen file

makefile		- file to compile the program

CONSTANTS
RAND_MAX		- The value defined for the maximum value the random function can 			generate
SAMPLE_INT_ARRAY_SIZE	- The value to define the size of an array

INSTRUCTION FOR COMPILING CODE
type "make" into the command line to compile the code

INSTRUCTION FOR RUNNING CODE
type ./at2 (integer) (integer) 
type ./at3
type ./at

TEST DATA
-bash-3.2$ ./at2 90 87 65 54
90
87
65
54
The sorted array is
90
87
65
54
size is 4

-bash-3.2$ ./at3
84
87
78
16
94
36
87
93
50
22
The sorted array is94
93
87
87
84
78
50
36
22
16
size is 10

