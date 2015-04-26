#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include "cptest.h"
// 
// /** Main program: copies a pathname to a different path name
//     @param argc Number of command-line arguments (including program name).
//     @param argv Array of pointers to character arays holding arguments.
//     @return 0 if successful, -1 if fail.
// */
 int main(int argc, char* argv[])
 {  
  	
  	char* copyfileversion = "copyfile1";// Which version of copyfile to be used: copyfile1, copyfile2, copyfile3
  	size_t buffersize = 1024;// Determine the Buffer Size for copyfile3
  	int returnstatus;// Return 1 if succeed, 0 if fail
	int i;//loop counter
	char* infile[argc];
  	if (argc < 3) {
    	usage(argv[0]); // Must have at least 3 arguments.
    	return 1;
  	}
	int flag[argc];
	for(i=0;i<argc;i++){
		flag[i]=0;
	}
	flag[0]=1;
	for(i=0;i<argc;i++){
		if(strcmp(argv[i],"-c")==0){
			copyfileversion = argv[i+1];
			flag[i]=1;
			flag[i+1]=1;
		}
		else if(strcmp(argv[i],"-b")==0){
			buffersize = (size_t)atoi(argv[i+1]);
			flag[i]=1;
			flag[i+1]=1;
		}
	}
	
	int n = 0;
	for(i=0;i<argc;i++){
		if(flag[i]==0){
			infile[i]=argv[i];
			n++;
			printf("path is: %s\n",infile[i]);
		}
	}
	
	DIR* tempdir;
	if ((tempdir = opendir(infile[n-1])) != NULL) { //directory
		for (i=0; i< n-1; i++) {
			copyDir(infile[i], infile[n-1],copyfileversion,buffersize);
		}
		closedir(tempdir);
	}
	
   	return 0;
 }


