#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "struct.h"
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>
#include <readline/readline.h>
#include <readline/history.h>


int main() {

	//------------------------Read File------------------------
	int readBinFile;
	int i;
	int fileContain = 0;
   	readBinFile = open("stest3.bin" , O_RDONLY);//open the file as read only
   	
	if (readBinFile >= 0) {
    	printf("File opened successfully\n");//check whether the file open succesfully
  	} else {
    	printf("Unable to open file. Error %d: %s\n", errno, strerror(errno));
    	return 1;
  	}
 	//go through each employee in the binary file and read the employee
   	//then print them out

	readEmpFromBin(readBinFile);
  
  	close(readBinFile);// close the file
    
    printf("Done Reading file\n");
   	
	//***********************End Reading***********************

  return 0;
}

