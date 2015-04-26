/** file at.cprint
 * @author Mike Ciaraldi
 *
 * Program to demonstrate arrays in C.
 */

#include "print_arrays.h"
#include "sort_arrays.h"
#define SAMPLE_INT_ARRAY_SIZE (10)

#include <stdio.h>
#include <stdlib.h>

/* Very simple program to demonstrate reading a number from the command line.
 * Usage:
 *         ./num some_number
 * Example:
 *         ./num 2014
 *
 */

int main (int argc, const char* argv[]) {
  	int n; // Integer read from the command line goes here
	int count;
	count = argc -1;
int arr[count];
	if (argc <2) {
		printf("Must enter a number on the command line!\n");
}
 getIntegersFromCommand(argv, count, arr);
printf("The sorted array is\n");
sortArray(arr,count);
	return 0; // Indicate success!

}
