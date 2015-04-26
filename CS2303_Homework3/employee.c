#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "mystring.h"
#include "employee.h"
/** Create an employee
 @param *name Name of the employee
 @param *birth_year birth year of the employee
 @param *start_year starting year of the employee
 @return Pointer to the employee created
*/
Employee  *make_employee(char* name , int birth_year, int start_year){
	Employee* employee = (Employee*)malloc(sizeof( Employee));//Create an employee
	char *tempName = name;//create a local pointer that is the same as name
	int i;
	i =0;//loop counter
	while (*tempName != '\0' && i < 100){//update the name field of the employee when tempName is not null
		employee -> name[i] = *tempName;// update the name filed of the employee
		tempName++;//move the pointer to the next location
		i++;
	}
	
	employee -> birth_year = birth_year;//update the birth year
	employee -> starting_year = start_year;//update the starting year
	return employee;
}
/** Create an employee with random information
 @return Pointer to the employee created
*/
 Employee  *make_random_employee(){
 	Employee* employee = (Employee*)malloc(sizeof( Employee));//Create an employee
 	char *tempName = stringGenerator();//generate a random string with a random size
 	int i;
 	int birth_year, start_year;
 	i =0;
 	//update the name field of the employee with the string generated
 	while (*tempName != '\0' && i < 100){
 		employee -> name[i] = *tempName;
 		tempName++;
 		i++;
 	}
 	
 	birth_year = rand()%2015;//generate a random birthyear and update the field
 	employee -> birth_year = birth_year;
 	start_year = rand()%2015;//generate a random start year and update the field
 	employee -> starting_year = start_year;
 	return employee;
 }
 /** Print an employee
 @param *employee Pointer to an existed employee
 @return Print out the information of the employee
*/
 void printEmployee(Employee *employee){
 	char nameArr[100];//create a string array same size as the size of an employee's name
 	int i;
 	for (i=0;i<100;i++){
 		nameArr[i] = employee -> name[i];//fill up the array with the employee's name
 	}
 	printf("Employee's name is ");//print the name
 	for(i=0; i<100; i++){
 		printf("%c", nameArr[i]);
 	}
 	//print the birth year and starting year
	printf(", year of birth is %d, starting year is %d\n", employee ->  birth_year, employee -> starting_year);
}
/** Generate a random string
 @return A string with random size and value
*/
char* stringGenerator(){
	int size, i;
	size = rand()%100;// create a random string with a random size less than or equal to the size of the name field
	char* strArr;
	strArr = (char*)malloc(100*sizeof(char));//malloc the array
	char alphabet[] = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";//array store all the alphabet symbols
	//fill the array up
	for (i = 0; i < size; i++) {
        strArr[i] = alphabet[rand() % (sizeof(alphabet) - 1)];
    }
	return strArr;
} 
/** Create an array to store the pointers of the pointers to employee
 @param count Number of employee to be stored into the array
 @return Array of pointers of employee that were randomly created
*/
Employee** arrPointer(int count){
	Employee** empArr = (Employee**)malloc(count*sizeof( Employee*));//create an array of pointers
	int i;
	
	for (i=0; i<count; i++){
		//fill the array with address of the employee
		empArr[i] = make_random_employee();
	}
	return empArr;
}
void printEmployeeStruct(int count, Employee** emp){
	int i;
	//go through the address of emp and print each employee
	for (i=0; i<count; i++){
		printEmployee(emp[i]);
	}
}
/** Duplicate an array of pointers of the pointers to employee
 @param count Number of employee to be duplicated
 @param **src The array to be duplicated
 @return Array of pointers of employee that is the same to src
*/
Employee** dupEmpArr(Employee** src, int count) {
  Employee** newArr; // Pointer to memory which will hold new array
  newArr = (Employee**) malloc(count*sizeof(Employee*)); // Must cast!
  // If no memory was available, return immediately
  if (newArr == 0) return (Employee**) 0;
  // Otherwise, copy the array and return pointer to new aray
 	int i;
	for (i=0; i<count; i++){
		newArr[i] = src[i];
	}
  return newArr;
}
/** Free all the employees pointed too
 @param **array The array of pointers to be freed
 @param count Number of employee of the array
 @return Free the allocated array
*/
void freeStructPointers(Employee** array, int count){
	int i;
	//go through each elements of array and free all the poiters
	for (i=0; i<count; i++){
		free(array[i]);
	}
}

