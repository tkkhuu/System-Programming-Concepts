#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "struct.h"
#include <readline/readline.h>
#include <readline/history.h>

int main() {
    printf("Starting program stest.\n");
    #ifdef DEBUG
    printf("DEBUG defined\n");
    #else
    printf("Not defined\n");
    #endif
    //--------------------Creating and Printing Employee--------------------------
    Employee* tri;
    Employee* jetro;
    tri = createEmployee(20000, "Tri", "Robotics");
    jetro = createEmployee(20000,"Jetro", "Electrical");
    // Anybody recognize these names?
    Employee harry; // Declare a local variable (a struct).
    harry.salary = 5000;
    harry.name = strdup("Harry Palmer"); // Make a dynamic copy.
    harry.dept = strdup("Mechanical");
    
    Employee bluejay; // Declare a local variable (a struct).
    bluejay.salary = 10000;
    bluejay.name = strdup("Erik Grantby"); // Make a dynamic copy.
    bluejay.dept = strdup("Computer Science");

    // Output the employees to stdout.
    printEmployee(&harry);
    printEmployee(&bluejay);
    printEmployee(tri);
    printEmployee(jetro);
    //---------------------Ending Employee---------------------
  
  
  	//---------------------Getting Employee's Info From Prompts------------------------- 
	
  	getEmployeeInfo(100, 100, 100);
  	
  	
  	//---------------------End Prompts------------------------- 
	//Output the employees to a file.
  	printf("About to write to file.\n");
  	FILE *outfile;
  	outfile = fopen("stest.txt", "w"); // Open or create file for writing
  	if(outfile != '\0'){// check if outfile can be opened
    	printf("outfile opened sucessfull\n");// prompt succes
    	// write the data to outfile
    	outputEmployee(outfile, &harry);
    	outputEmployee(outfile, &bluejay);
    	outputEmployee(outfile, tri);
    	outputEmployee(outfile, jetro);
    	fclose(outfile);// close outfile
 	}
  	else{
    	fprintf(stderr, "Uh-oh!\n");//print error if file can't be opened
  	}
 

  	printf("Ending program stest.\n"); 
  	return 0;
}


