#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include "cptest.h"

/** Main program: copies a pathname to a different path name
    @param argc Number of command-line arguments (including program name).
    @param argv Array of pointers to character arays holding arguments.
    @return 0 if successful, -1 if fail.
*/
int main(int argc, char* argv[])
{  
  	char* infilename; // Name of file to be copied.
  	char* outfilename;// Name of the copied file
  	char* copyfileversion;// Which version of copyfile to be used: copyfile1, copyfile2, copyfile3
  	size_t buffersize;// Determine the Buffer Size for copyfile3
  	int returnstatus;// Return 1 if succeed, 0 if fail

  	if (argc < 3) {
    	usage(argv[0]); // Must have at least 2 arguments.
    	return 1;
  	}

  	infilename = argv[1];
  	outfilename = argv[2];
  	if(argv[3] != NULL){
  		copyfileversion = argv[3];
  	}
  	else{
  		copyfileversion = "copyfile1";
  	}
   	if(strcmp(copyfileversion,"copyfile3")==0){
		if(argc == 5){
			buffersize = (size_t)atoi(argv[4]);
		}
		else{
			buffersize = 1024;
		}
		
	}
  	
  	// Perform the copying
	returnstatus = copyDir (infilename, outfilename, copyfileversion, buffersize);
  	return returnstatus;
}















