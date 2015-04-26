#include <stdio.h>
#include <string.h>
// string.h covers the C-style string functions.
#include "mystring.h"
#include "employee.h"
/** ctest.c
 * Program to demonstrate character arrays and
 * dynamically-allocated memory.
 * @author Mike Ciaraldi
 */

const int MAX_CHARS = 20; // Maximum number of characters in array

int main()
{
  char a1[MAX_CHARS + 1]; // Character array--initially empty
  char a2[] = "Hello"; // Character array--unsized but initialized
  char a3[MAX_CHARS + 1]; // Character array--we will underfill it
  char* p1 = "Hello"; // Pointer to constant string
  char* p2;           // Will be a pointer to dynamically-allocated string
  char* p3;		// pointer to a string to be tested by mystrnup
  Employee** empArray;// array of pointers of pointers that points to the employee
  Employee** dupEmpArray;// created to duplicate empArray
  int copy_limit;     // Maximum characters to copy.
  size_t length;
  srand(time(NULL));// initialize to use rand()
  // Create employee
  Employee *employee1 = make_random_employee();
  Employee *employee2 = make_employee("Peter",1993,21);
  Employee *employee3 = make_random_employee();
  Employee *employee4 = make_random_employee();
  Employee *employee5 = make_random_employee();
  
  empArray = arrPointer(4);//Test the arrPointer function
  dupEmpArray = dupEmpArr(empArray, 4);// Test the duplicate pointer function
  printEmployeeStruct(4, empArray);//print the employees that stored in an array
  printf("\n");// print an empty line to make more clear
  printEmployeeStruct(4, dupEmpArray);//print the duplicated array to test
  freeStructPointers(dupEmpArray, 4);// free the allocated array
  mystrcpy(a3, "Hello, also"); // Initialize uinderfilled character array
  printEmployee(employee2);//print the information of an employee

  
  /* Print the pointers.
     Note: this example prints
     the values of the pointers themselves, not the targets.
  */
  printf("Pointers: a1 = %p, a2 = %p, a3 = %p\n", a1, a2, a3);
  printf("          p1 = %p p2 = %p\n", p1, p2);

  mystrcpy(a1, "Hi"); // Initialize character array
  length = mystrlen(a1);
  printf("a1 = %s\n", a1);
  printf("a2 = %s\n", a2);
  printf("a3 = %s\n", a3);
  printf("length = %d\n", length);//test mystrlen()
  // Concatenate two character arrays, then print.
  mystrcat(a1, a2);
  printf("a1 = %s\n", a1);
  length = mystrlen(a1);
  printf("length is %d\n", length);
  // Concatenate two character arrays safely, then print.
  copy_limit = MAX_CHARS - mystrlen(a1); // How much space is left?
  if (copy_limit > 0) strncat(a1,a2, copy_limit);
  printf("a1 = %s\n", a1);

  // Concatenate two character arrays safely, then print.
  copy_limit = MAX_CHARS - mystrlen(a1); // How much space is left?
  if (copy_limit > 0) mystrncat(a1, a3, copy_limit);
  printf("a1 = %s\n", a1);

  // Duplicate a string, using my function, then print
  printf("Before dup, pointer a2 = %p, contents = %s\n", a2, a2);
  p2 = mystrdup(a2);
  printf("Pointer p2 = %p, contents = %s\n", p2, p2);
  p3 = mystrndup(a2, 4);//test mystrndup
  printf("Pointer p3 = %p, contents = %s\n", p3, p3);//test mystrndup()
  
  return 0;
}
