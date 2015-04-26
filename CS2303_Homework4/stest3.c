#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "struct.h"
#include <readline/readline.h>
#include <readline/history.h>



int main() {

	//------------------------Read File------------------------
	FILE * empData;
	Employee *employee1;
	Employee *employee2;
	Employee* empArray[MAX_EMPLOYEE];
	int i;
	int fileContain = 0;
	//determine how many employee in the file and compare to the array size
   	empData = fopen("stest2.txt" , "r");
   	
   	while(employeeInfo(empData) != '\0'){
   		fileContain++;
   	}
   	fclose(empData);
   	
	//prompt if the array size is not enough
   	if(fileContain > MAX_EMPLOYEE){
   		fprintf(stderr, "File is too large\n");
   		printf("------------------------------------------------\n");
   	}
   	
   	// start reading
   	empData = fopen ("stest2.txt" , "r");
	if (empData == '\0') {printf("Error opening file\n");}
   	else {	
   		printf("File opened sucessfully\n");
   		//read each info of the employee in the file and print it out
   		for(i=0;i<MAX_EMPLOYEE;i++){
   			printf("----------------------------------------------------------------------\n");
   			empArray[i] = employeeInfo(empData);
   			if(empArray[i] != '\0'){
   				printEmployee(empArray[i]);	
   			}
   		}
    }
    fclose(empData);
    
    printf("Done Reading file\n");
   	
	//***********************End Reading***********************

  return 0;
}

