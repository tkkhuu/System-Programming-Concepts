// function prototype
#ifndef CPTEST_H_
#define CPTEST_H_
#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <dirent.h>
#include <libgen.h>
#include <unistd.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
int copyfile1(char* infilename, char* outfilename);
void usage(char* program_name);
void open_file_error(char* filename);
int copyfile1(char* infilename, char* outfilename);
int copyfile2(char* infilename, char* outfilename);
int copyfile3(char* infilename, char* outfilename, size_t bufsize);
int copyfile(char* which_copy_version, char* infilename, char* outfilename, size_t bufsize);
float runningTimeInSec(struct timeval begintime, struct timeval finishtime);
int copyDir (char *inPath, char* outPath, char* which_copy_version, size_t bufsize);
#endif


