/** file print_arrays.c
 * @author Mike Ciaraldi
 *
 * Functions for printing arrays.
 */

#include <stdio.h>
#include <stdlib.h>
#include "print_arrays.h"

/** Print an array of ints, one per line.
    @param a Array to print
    @param num_elements Number of elements in the array
*/

void print_int_array(int a[], int num_elements) {
  int i; // Loop counter
  for (i = 0; i < num_elements; i++) {
    printf("%d\n", a[i]);
  }
}

/** Print an array of doubles, one per line.
    @param a Array to print
    @param num_elements Number of elements in the array
*/
void print_double_array(double a[], int num_elements) {
int j;// loop counter
for (j = 0; j < num_elements; j++){
printf("%f\n", a[j]); //for each loop iteration, print out each element in the array according to i
}
}

/** Getting integer data from the command line and storing it to an array
    @param array Array that received from the command line
    @param size Number of elements in the array
    @param arr The array that will store the elements of the other aray
*/
void getIntegersFromCommand(const char* array[], int size, int arr[]){
	int i;// loop counter
	for(i = 0; i <size; i++){
 		arr[i] =atoi(array[i+1]);// for each loop iteration, convert the elements from the char array to an integers and store in the int array
		}
  	print_int_array(arr, size);// print the resulted array
}





















