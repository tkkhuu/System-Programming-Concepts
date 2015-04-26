#define RAND_MAX (100)
#include <stdio.h>
#include <stdlib.h>
#include "print_arrays.h"
#include "sort_arrays.h"
/** Sorts an array of integer in descending order and print that array
    @param array Array to sort
    @param sizeArray Number of elements in the array
*/
void sortArray(int array[], int sizeArray){
		int i, j;// loop counters
        int n;// a variable to perform swapping
	// sorting an array in descending order needs 2 for loop to implement
	// the for loop will compare 2 adjacent elements in an array, the larger elements will be placed in the smaller index
        for(j=0; j < sizeArray-1; j++){
        	for (i=0; i < sizeArray-1;i++){
            	    if(array[i] <= array[i+1]){
                	        n = array[i];
                    	    array[i] = array[i+1];
                        	array[i+1] = n;
                	}
			}

		}
		//print out the sorted array
		printf("The sorted array is");
		print_int_array(array, sizeArray);
		// print out the size of the array for testing purpose
		printf("size is %d\n",sizeArray);
}
/** Generate a random integer from 0 to a certain value including the end points
    @param range the max value that the function can output 
*/
int generateRandomInt (int range){
	int randomNumber;
	randomNumber =	random()%range+1; // using the random() funciton to generate a random number from 0 to range-1

				// add one to the result to make sure the generated number includes the endpoints

return randomNumber;		// return the value
}
/** Fill in an array of specified size with random numbers from zero to a specified maximum
    @param array An integer array to be filled
    @param size Size of the array
*/
void fillArray(int array[], int size){
	int i;// loop counter
	for (i=0; i< size; i++){
		array[i] = generateRandomInt(100);// fill the array with random number each loop
	}
}
