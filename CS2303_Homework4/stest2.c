#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "struct.h"
#include <readline/readline.h>
#include <readline/history.h>

int main() {
    //--------------------Entering Employees--------------------------
	int numbofemp = numberOfEmp();//create a size for an array according to the number of employee
	Employee *empArr[numbofemp + 1];//create the array, leave one extra spot for the null terminator

	int employeeEntered = 0;//loop counter
	//go through loop to enter each info of employee
	while(employeeEntered< numbofemp){
		printf("\n Please enter the info of employee: %d\n", employeeEntered+1);
		empArr[employeeEntered] = getEmployeeInfo(100,100,100);
		employeeEntered++;
		empArr[numbofemp+1] = '\0';
	}
	int i; //loop counter
	// print out all the employee
	for(i = 0; i<(numbofemp); i++){
		printEmployee(empArr[i]);
	}
    //---------------------Ending Entering Employee---------------------

  	
  	//----------------------Write to File----------------------
   	printf("About to write to file.\n");
	FILE *empfile;
   	empfile = fopen("stest2.txt", "w"); // Open or create file for writing
   	if(empfile != '\0'){//check if the fie can be opened
     	printf("empfile opened sucessfull\n");//prompt success
     	for(i = 0; i<(numbofemp); i++){//write each info of the employee to the file
     		writeEmpDataToFile(empfile, empArr[i]);
     		free(empArr[i]);// free all allocated memory
     	}
     	fclose(empfile);//close the file
  	}
   	else{
     	fprintf(stderr, "empfile can't be opened!\n");
   	}
  
 
   	printf("Ending program stest.\n"); 
	//-----------------------End Writing File-----------------------------
  return 0;
}


