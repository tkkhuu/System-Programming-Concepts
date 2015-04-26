//
//  struct.c
//  Assign4
//
//  Created by Tri Khuu on 15/02/15.
//  Copyright (c) 2015 Khuu. All rights reserved.
//
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <readline/readline.h>
#include <readline/history.h>
#include "struct.h"
//-------------------------------------------------------------------------------------------
/** Prints the contents of an Employee struct to standard output.
 * @param employee Pointer to the Employee struct to print
 */
void printEmployee(Employee *employee) {
    outputEmployee(stdout, employee);
}
//-------------------------------------------------------------------------------------------
/** Prints the contents of an Employee struct to a stream,
 * such as an already-opened file.
 * @param stream A pointer to a FILE struct representing an already-open
 *     stream, such as stdout, stderr, or a file.
 * @param employee Pointer to the Employee struct to print
 */
void outputEmployee(FILE *stream, Employee *employee) {
    fprintf(stream, "Employee: Name = %s, Salary = %d, Department = %s\n",
            employee->name, employee->salary, employee->dept);
}
//-------------------------------------------------------------------------------------------
/** Prints the contents of an Employee struct to a stream,
 * such as an already-opened file with each piece of data on a separate line
 * @param stream A pointer to a FILE struct representing an already-open
 * 		stream, such as stdout, stderr, or a file.
 * @param employee Pointer to the Employee struct to print
 */
void writeEmpDataToFile(FILE *stream, Employee *employee){
	//copy the data to local variables and write to the file stream
	char *name = employee -> name;
	char *dept = employee -> dept;
	int salary = employee -> salary;
	fprintf(stream, "%s\n",name);
	fprintf(stream, "%s\n", dept);
	fprintf(stream, "%d\n",salary);
}
//-------------------------------------------------------------------------------------------
/** Prints the contents of an Employee struct to a binary file,
 * such as an already-opened file with each piece of data on a separate line
 * @param stream A pointer to a FILE struct representing an already-open
 * 		stream, such as stdout, stderr, or a file.
 * @param employee Pointer to the Employee struct to print
 */
void writeEmpDataToBinaryFile(int pathname, Employee *employee){
	// copy the data to local variable 
  	struct bEmployee empl;
	char *tempname = employee -> name;
 	char *tempdept = employee -> dept;
 	int tempsalary = employee -> salary;
  	empl.salary = 20;
  	strncpy(empl.name, tempname, 100);
  	strncpy(empl.dept, tempdept, 100);
  	//write to the binary file
	
	write(pathname, &empl, sizeof(struct bEmployee));

}
//-------------------------------------------------------------------------------------------
/** Create a new Employee
 * @param salary The salary of the employee
 * @param name The name of the employee as a dynamically-allocated C string
 * @param dept The name of the department of the employee as a dynamically-allocated C string
 * @return Pointer to the new Employee created
 */
Employee* createEmployee(int salary, char* name, char* dept){
//malloc an employee and update this employee with the information
    Employee* employee = (Employee*)malloc(sizeof(Employee));
    char* tempName;
    char* tempDept;
    
    tempName = strdup(name);
    tempDept = strdup(dept);
    
    employee -> name = tempName;
    employee -> dept = tempDept;
    employee -> salary = salary;
    //return the employee
    return employee;
}
//-------------------------------------------------------------------------------------------
/** Prompt the user to enter an Employee's information then create and print out a new employee 
 * with the entered information
 * @param nameSize The maximum number of characters that can be entered for name
 * @param deptSize The maximum number of characters that can be entered for department
 * @param salSize The maximum number of digits that can be entered for salary
 * 
 */

Employee* getEmployeeInfo(int nameSize, int deptSize, int salSize){
//create a local employee to return
	Employee* emp;
//make a copy of the fileds
    char *getName; 
   	char empName[nameSize]; 
   	char tempEmpName[nameSize];
  	
  	char *getDept; 
   	char empDept[deptSize]; 
   	char tempEmpDept[deptSize];
   	
   	char *getSalary;
   	char tempEmpSalary[salSize];
  	int empSalary; 
  	//variable to check whether sscanf suceeded
  	int nameValid; 
  	int deptValid;
  	int salaryValid;
  	int goodinput = 0; // Flag: 0 = false = Input not yet good  
  	
  	while (!goodinput) {
  	//ask the user to enter the info
    	getName = readline("Enter the employee's name: "); // Read the input line
    	getDept = readline("Enter the employee's department: "); // Read the input line
    	getSalary = readline("Enter the employee's salary: ");
    	//update the local copies of the fields
    	strcpy(tempEmpName,getName);
    	strcpy(tempEmpDept,getDept);
    	strcpy(tempEmpSalary,getSalary);
    	//confirm what was entered
    	printf("You just entered {%s} for Name, {%s} for Department and {%s} for Salary\n", tempEmpName, tempEmpDept, tempEmpSalary); // Echo it
    	//parse the data
     	nameValid = sscanf(tempEmpName, "%s", empName); // Try to convert
     	deptValid = sscanf(tempEmpDept, "%s", empDept);
     	salaryValid = sscanf(tempEmpSalary, "%d", &empSalary);
     	//print out if valid, if not print an error message
     	if ((nameValid > 0) && (deptValid>0) && (salaryValid > 0)) {
     	  	printf("%s is a valid Name\n", empName);
     	  	printf("%s is a valid Department\n", empDept);
     	  	printf("%d is a valid Salary\n", empSalary);
     	  	emp = createEmployee (empSalary, empName, empDept);
     	  	printEmployee(emp);
     	  	goodinput = 1; // Break out if successful
     	  	
    	 	} else {
    	   		printf("Please Enter a valid information\n");
    	 	}
 	 }
 	 //return the employee
 	 return emp;
}
//-------------------------------------------------------------------------------------------
/** Prompts the user to enter the number of employee and return that value
 * @return The number of employee entered in the command line
 */
int numberOfEmp (){
	char *numofEmp; //variable to record readline
   	char tempnum[1000];//array to be parsed
   	int numberofEmployee;//value to be returned
   	int isValid;//check if sscanf succeeded
   	char goodinput = 0;
  	
  	while (!goodinput) {
  		numofEmp = readline("\n Please enter the number of employee: ");
     	strcpy(tempnum,numofEmp);   	
      	isValid = sscanf(tempnum, "%d", &numberofEmployee); // Try to convert
      	if(isValid > 0){
      		printf("\n There are %d employees\n\n", numberofEmployee);
      		goodinput = 1;
      	}
      	else{
      		printf("\n Please enter a valid number of employee\n");
      	}
 	 }
 	 return numberofEmployee;
}
//-------------------------------------------------------------------------------------------
/** Read the information of an employee on a file and create the employee
 * @param data The file to read from
 * @return The created employee with the information read from the file
 */
Employee* employeeInfo(FILE* data){

	char * empInfo = (char*)malloc(sizeof(char));
	Employee* emp = (Employee*)malloc(sizeof(Employee));
	
	char mystring[100];
	char empName[100];
   	char empDept[100];
   	int empSalary;
   	
   	int hasData;
   	
   	int j;	
 	for(j=0;j<3; j++){
 		if(fgets(mystring , 100 , data) != '\0'){
 			strcat(empInfo, mystring);
 			hasData = 1;
 		}
 		else {hasData =0;}
    }
    if(hasData == 1){
    printf("emp info is %s\n",empInfo);
    sscanf(empInfo, "%s %s %d",empName, empDept, &empSalary);
    
    char* name = strdup(empName);
    char* dept = strdup(empDept);
    
    emp -> name = name;
    emp -> dept = dept;
    emp -> salary = empSalary;
     
    return emp;
    }
    else{
    	return (Employee*)'\0';
    }
}
//-------------------------------------------------------------------------------------------
/** Read the information of an employee on a binary file and print out the employee
 * @param pathname The file to read from
 */
void readEmpFromBin(int pathname){
	int i;
	struct bEmployee employee[MAX_EMPLOYEE];

  	/* Now read it from the file */
  	for(i=0;i<MAX_EMPLOYEE;i++){
  		
  		ssize_t count = read(pathname, &(employee[i]), sizeof(struct bEmployee));
		
  		if (count == sizeof(struct bEmployee)) {
			printf("Employee: Name: %s, Dept: %s, Salary: %d\n", employee[i].name, employee[i].dept, employee[i].salary);
  		}
  		
	}
}



