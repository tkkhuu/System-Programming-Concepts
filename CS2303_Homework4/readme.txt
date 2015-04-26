Name: Tri Khuu:
Username: tkkhuu

LIST OF FILES
stest.c				- contains the source code for assignment 4 section A
stest2.c			- contains the source code for assignment 4 section B Part 3
stest3.c			- contains the source code for assignment 4 section B Part 4
stest4.c			- contains the source code for assignment 4 section B Part 5
stest5.c			- contains the source code for assignment 4 section B Part 6

struct.c			- contains source code for all the Employee operation

struct.h			- contains the function prototypes defined in struct.c

Doxyfile			- contains the information to create the doxygen file

makefile			- file to compile the program

CONSTANTS
MAX_EMPLOYEE = 5	- The value defined for the maximum value of the array size


INSTRUCTION FOR COMPILING CODE
type "make" into the command line to compile the code

INSTRUCTION FOR RUNNING CODE
type ./stest
type ./stest2
type ./stest3
type ./stest4
type ./stest5

TEST DATA
//------------------------------stest-----------------------------
-bash-3.2$ ./stest 
Starting program stest.
DEBUG defined
Employee: Name = Harry Palmer, Salary = 5000, Department = Mechanical
Employee: Name = Erik Grantby, Salary = 10000, Department = Computer Science
Employee: Name = Tri, Salary = 20000, Department = Robotics
Employee: Name = Jetro, Salary = 20000, Department = Electrical
Enter the employee's name: Tri
Enter the employee's department: RBE
Enter the employee's salary: 87
You just entered {Tri} for Name, {RBE} for Department and {87} for Salary
Tri is a valid Name
RBE is a valid Department
87 is a valid Salary
Employee: Name = Tri, Salary = 87, Department = RBE
About to write to file.
outfile opened sucessfull
Ending program stest.
-bash-3.2$ 
//****************************End stest****************************
//------------------------------stest2-----------------------------
-bash-3.2$ ./stest2

 Please enter the number of employee: 4  

 There are 4 employees


 Please enter the info of employee: 1
Enter the employee's name: A
Enter the employee's department: RBE
Enter the employee's salary: 45
You just entered {A} for Name, {RBE} for Department and {45} for Salary
A is a valid Name
RBE is a valid Department
45 is a valid Salary
Employee: Name = A, Salary = 45, Department = RBE

 Please enter the info of employee: 2
Enter the employee's name: B
Enter the employee's department: CS
Enter the employee's salary: 56
You just entered {B} for Name, {CS} for Department and {56} for Salary
B is a valid Name
CS is a valid Department
56 is a valid Salary
Employee: Name = B, Salary = 56, Department = CS

 Please enter the info of employee: 3
Enter the employee's name: C
Enter the employee's department: ME
Enter the employee's salary: #$
You just entered {C} for Name, {ME} for Department and {#$} for Salary
Please Enter a valid information
Enter the employee's name: D
Enter the employee's department: ECE
Enter the employee's salary: ^&
You just entered {D} for Name, {ECE} for Department and {^&} for Salary
Please Enter a valid information
Enter the employee's name: D
Enter the employee's department: ECE
Enter the employee's salary: 67
You just entered {D} for Name, {ECE} for Department and {67} for Salary
D is a valid Name
ECE is a valid Department
67 is a valid Salary
Employee: Name = D, Salary = 67, Department = ECE

 Please enter the info of employee: 4
Enter the employee's name: D
Enter the employee's department: ME
Enter the employee's salary: 34
You just entered {D} for Name, {ME} for Department and {34} for Salary
D is a valid Name
ME is a valid Department
34 is a valid Salary
Employee: Name = D, Salary = 34, Department = ME
Employee: Name = A, Salary = 45, Department = RBE
Employee: Name = B, Salary = 56, Department = CS
Employee: Name = D, Salary = 67, Department = ECE
Employee: Name = D, Salary = 34, Department = ME
About to write to file.
empfile opened sucessfull
Ending program stest.
-bash-3.2$ 
//****************************End stest2****************************

//------------------------------stest3-----------------------------
-bash-3.2$ ./stest3
emp info is A
RBE
45

emp info is B
CS
56

emp info is D
ECE
67

emp info is D
ME
34

File opened sucessfully
----------------------------------------------------------------------
emp info is A
RBE
45

Employee: Name = A, Salary = 45, Department = RBE
----------------------------------------------------------------------
emp info is B
CS
56

Employee: Name = B, Salary = 56, Department = CS
----------------------------------------------------------------------
emp info is D
ECE
67

Employee: Name = D, Salary = 67, Department = ECE
----------------------------------------------------------------------
emp info is D
ME
34

Employee: Name = D, Salary = 34, Department = ME
----------------------------------------------------------------------
Done Reading file
-bash-3.2$ 
//****************************End stest3****************************

//------------------------------stest4-----------------------------
-bash-3.2$ ./stest4

 Please enter the number of employee: 4

 There are 4 employees


 Please enter the info of employee: 1
Enter the employee's name: A
Enter the employee's department: RBE
Enter the employee's salary: 45
You just entered {A} for Name, {RBE} for Department and {45} for Salary
A is a valid Name
RBE is a valid Department
45 is a valid Salary
Employee: Name = A, Salary = 45, Department = RBE

 Please enter the info of employee: 2
Enter the employee's name: B
Enter the employee's department: CS
Enter the employee's salary: *(
You just entered {B} for Name, {CS} for Department and {*(} for Salary
Please Enter a valid information
Enter the employee's name: B
Enter the employee's department: CS
Enter the employee's salary: 89
You just entered {B} for Name, {CS} for Department and {89} for Salary
B is a valid Name
CS is a valid Department
89 is a valid Salary
Employee: Name = B, Salary = 89, Department = CS

 Please enter the info of employee: 3
Enter the employee's name: C
Enter the employee's department: ECE
Enter the employee's salary: 98
You just entered {C} for Name, {ECE} for Department and {98} for Salary
C is a valid Name
ECE is a valid Department
98 is a valid Salary
Employee: Name = C, Salary = 98, Department = ECE

 Please enter the info of employee: 4
Enter the employee's name: D
Enter the employee's department: ME
Enter the employee's salary: 97
You just entered {D} for Name, {ME} for Department and {97} for Salary
D is a valid Name
ME is a valid Department
97 is a valid Salary
Employee: Name = D, Salary = 97, Department = ME
Employee: Name = A, Salary = 45, Department = RBE
Employee: Name = B, Salary = 89, Department = CS
Employee: Name = C, Salary = 98, Department = ECE
Employee: Name = D, Salary = 97, Department = ME
About to write to file.
binaryfile opened sucessfull
Ending program stest.
-bash-3.2$ 
//****************************End stest4****************************

//------------------------------stest5-----------------------------
-bash-3.2$ ./stest5
File opened successfully
Employee: Name: A, Dept: RBE, Salary: 45
Employee: Name: B, Dept: CS, Salary: 89
Employee: Name: C, Dept: ECE, Salary: 98
Employee: Name: D, Dept: ME, Salary: 97
Done Reading file
-bash-3.2$ 

//****************************End stest5****************************