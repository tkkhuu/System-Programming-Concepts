#include "print_arrays.h"
#include "sort_arrays.h"
#define SAMPLE_INT_ARRAY_SIZE (10)
#define RAND_MAX (100)
#include <stdio.h>
#include <stdlib.h>

/** Program to fill in an array with random numbers, print it and sort it then print it again
 * Usage:
 *         ./num some_number
 * Example:
 *         ./num 2014
 *
 */

int main () {
	int array[SAMPLE_INT_ARRAY_SIZE];// define an array to be filler
	fillArray(array, SAMPLE_INT_ARRAY_SIZE);// fill the array with random numbers
	print_int_array(array, SAMPLE_INT_ARRAY_SIZE);// print the filled array
	sortArray(array, SAMPLE_INT_ARRAY_SIZE);

return 0;
}



























