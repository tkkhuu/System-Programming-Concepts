
#include "cptest.h"
/**
   Prints usage instructions.
   @param program_name the name of this program
*/
void usage(char* program_name)
{  
  printf("Usage: %s infile outfile copyfile(optional)\n", program_name);
}

/**
   Prints file opening error message
   @param filename the name of the file that could not be opened
*/
void open_file_error(char* filename)
{  
  printf("Error opening file %s\n", filename);
}

/** Copies one file to another using formatted I/O, one character at a time.
 @param infilename Name of input file
 @param outfilename Name of output file
 @return 0 if successful, 1 if error.
*/
int copyfile1(char* infilename, char* outfilename) {
  	FILE* infile; //File handles for source and destination.
  	FILE* outfile;
	
	struct timeval begintime;
 	struct timeval finishtime;
  	infile = fopen(infilename, "r"); // Open the input and output files.
  	if (infile == NULL) {
  	printf("Can't open infile\n");
   	open_file_error(infilename);
    	return 1;
  	}

  	outfile = fopen(outfilename, "w");
  	if (outfile == NULL) {
  	printf("Can't open outfile\n");
    	open_file_error(outfilename);
    	return 1;
  	}

  	int intch;  // Character read from input file. must be an int to catch EOF.
  	unsigned char ch; // Character stripped down to a byte.

  	// Read each character from the file, checking for EOF.
  	gettimeofday(&begintime,NULL);
  	while ((intch = fgetc(infile)) != EOF) {
    	ch = (unsigned char) intch; // Convert to one-byte char.
    	fputc(ch, outfile); // Write out.
  	}
	gettimeofday(&finishtime,NULL);
  // All done--close the files and return success code.
  	fclose(infile);
  	fclose(outfile);
  	runningTimeInSec(begintime, finishtime);
	return 0; // Success!
}


/** Copies one file to another using integer file descriptor, one character at a time.
 @param infilename Name of input file
 @param outfilename Name of output file
 @return 0 if successful, 1 if error.
*/
int copyfile2(char* infilename, char* outfilename){
	char buf;
	int inFile, outFile;
	struct timeval begintime;
 	struct timeval finishtime;
	//open out file 
	if (outFile = open(outfilename, O_RDWR | O_CREAT)) {
		if (inFile = open(infilename, O_RDONLY)) {
			gettimeofday(&begintime,NULL);
			while (read(inFile, &buf, sizeof(buf)) != 0) {
				write(outFile, &buf, 1);
			}
			gettimeofday(&finishtime,NULL);
			close(inFile);
		}
		close(outFile);
	}
	runningTimeInSec(begintime, finishtime);
	return 0;
}


/** Copies one file to another using integer file descriptor with a defined buffer size.
 @param infilename Name of input file
 @param outfilename Name of output file
 @param bufsize Buffer size for copying
 @return 0 if successful, 1 if error.
*/

int copyfile3(char* infilename, char* outfilename, size_t bufsize){
	char* buf = (char*) malloc(bufsize);
	int inFile, fileread, outFile;
	struct timeval begintime;
 	struct timeval finishtime;
	//open out file 
	if (outFile = open(outfilename, O_RDWR | O_CREAT)) {
		if (inFile = open(infilename, O_RDONLY)) {
			gettimeofday(&begintime,NULL);
			while ((fileread = read(inFile, buf, bufsize)) != 0) {
				write(outFile, buf, fileread);
			}
			gettimeofday(&finishtime,NULL);
			close(inFile);
		}
		close(outFile);
	}
	runningTimeInSec(begintime,finishtime);
	return 0;
}

/** Copies one file to another using the indicated version.
 @param which_copy_version The copy version to be used to perform copying
 @param infilename Name of input file
 @param outfilename Name of output file
 @param bufsize Buffer size for copying
 @return 0 if successful, 1 if error.
*/
int copyfile(char* which_copy_version, char* infilename, char* outfilename, size_t bufsize){
	//If the user typed "copyfile2" in the command line, use copyfile2
	if(strcmp(which_copy_version, "copyfile2")==0){
		printf("copyfile2 was used to perform copying\n");
  		return copyfile2(infilename, outfilename);
  	}
  	//If the user typed "copyfile3" and the buffer size in the command line, use copyfile3
  	else if(strcmp(which_copy_version, "copyfile3")==0){
  		printf("copyfile3 was used to perform copying\n");
  		return copyfile3(infilename, outfilename,bufsize);
  	}
  	//If the user typed "copyfile1" or don't type anything in the command line, use copyfile1
  	else{
  		printf("copyfile1 was used by default to perform copying\n");
  		return copyfile1(infilename, outfilename);
  	}
}

/** Calculate and Print out the beginning time, ending time and the difference
 @param beginTime The begin time value
 @param finishTime The finish time value
 @return The time difference between begin and finish
*/

float runningTimeInSec(struct timeval begintime, struct timeval finishtime){
	//Figuring out the run time by subtracting the begin time from end time 
	float runningTime = (float)(finishtime.tv_sec - begintime.tv_sec) + ((float)(finishtime.tv_usec - begintime.tv_usec)/1000000);
	if(runningTime >= 0){// if runtime is not negative
		long int totalinsec = runningTime;//figure out the runtime in seconds
		long int totalinmicrosec = (runningTime - totalinsec)*1000000;//figure out the runtime in micro seconds
		printf("Start Time: %ld seconds, %ld microseconds\n", begintime.tv_sec, begintime.tv_usec);//Print start time
		printf("End Time: %ld seconds, %ld microseconds\n", finishtime.tv_sec, finishtime.tv_usec);//Print end time
		printf("Total Run Time: %ld seconds, %ld microseconds\n", totalinsec, totalinmicrosec);//Print total running time
		printf("Total Run Time in Decimal: %.6f\n", runningTime);//Print out running time in decimal format
		return runningTime;
	}
	else{//If run time is negative, print an error
		printf("Run time is negative, begin time and end time maybe reversed\n");
		return 0;
	}
}

/** Copy a path name to a different path name
 @param inPath Pathname of the input 
 @param outPath Pathname of the output
 @param which_copy_version Version of copyfile to be used
 @param bufsize Buffer size to be used by copyfile3
 @return 0 if successful, 1 if error.
*/
int copyDir (char *inPath, char* outPath, char* which_copy_version, size_t bufsize)
{	
	DIR *dirp;
	
	if ((dirp=opendir(inPath)) != NULL) { //this is a directory
		DIR *outdirp;
		struct dirent *dp;
		if ((outdirp = opendir(outPath)) != NULL) {
			while ((dp = readdir(dirp)) != NULL) { 
				char* fileName = dp->d_name; //current file
				if (strcmp(fileName, ".") != 0 && strcmp(fileName, "..")) {
					printf("In base: %s\n", inPath);
					char inFileName[256];
					strcpy(inFileName, inPath);
					strcat(inFileName, "/");
					strcat(inFileName, fileName);
					printf("In file name is: %s\n", inFileName);
				
					char outFileName[256];
					strcpy(outFileName, outPath);
					strcat(outFileName, "/");
					strcat(outFileName, fileName);
					printf("concat outfile %s\n", outFileName);
				
					DIR *tmpOpen;
					if ((tmpOpen = opendir(inFileName)) != NULL) {
						mkdir(outFileName, S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH);
						copyDir(inFileName, outFileName, which_copy_version, 1024);
						closedir(tmpOpen);
					} else {
						copyfile(which_copy_version,inFileName, outFileName,bufsize);
					}
					
				}
			}
			closedir(outdirp);
		} else {
			printf("Infile is a directory, Outfile is not a directory\n");
			return -1;
		}
		closedir(dirp);
		
	} else { //if not a directory or something failed
		char* outFileName = outPath;
		DIR *outdirp;
		if ((outdirp = opendir(outFileName)) != NULL) { //if out is a directory
			strcat(outFileName, "/");
			strcat(outFileName, basename(inPath));
			closedir(outdirp);
		}
		copyfile(which_copy_version,inPath, outFileName,bufsize);
		
	}
	
	return 0;
}
