#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "struct.h"
#include <readline/readline.h>
#include <readline/history.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>


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
	for(i = 0; i<(numbofemp); i++){
		printEmployee(empArr[i]);
	}
    //---------------------Ending Entering Employee---------------------

  	
  	//----------------------Write to File----------------------
   	printf("About to write to file.\n");
	int binaryfile;
   	binaryfile = open("stest3.bin", O_WRONLY | O_CREAT | O_TRUNC,
                S_IRUSR | S_IWUSR); // Open or create file for writing
   	if(binaryfile >= 0){
     	printf("binaryfile opened sucessfull\n");//prompt if file can be opened
     	 for(i = 0; i<(numbofemp); i++){//go through each employee and write the data to the binary file
     		writeEmpDataToBinaryFile(binaryfile, empArr[i]);

      	}
     	close(binaryfile);//close the file
  	}
   	else{
     	fprintf(stderr, "empfile can't be opened!\n");//print out error if file can't be opened
   	}
   	printf("Ending program stest.\n"); 
	//-----------------------End Writing File-----------------------------
  return 0;

}


