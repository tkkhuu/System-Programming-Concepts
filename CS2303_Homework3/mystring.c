/** mystring.c
 * @author Mike Ciaraldi
 * My own versions of some of the C-style string functions
*/
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "mystring.h"


/** Duplicates a C-style string.
 @param src Pointer to string to be copied
 @return Pointer to freshly-allocated string containing a duplicate of src
         or null if no memory is available
*/
char* mystrdup(const char* src) {
  int length; // Length of the source string
  char* newstr; // Pointer to memory which will hold new string

  length = mystrlen(src) + 1;  // Leave space for the terminator
  newstr = (char*) malloc(length); // Must cast!

  // If no memory was available, return immediately
  if (newstr == 0) return (char *) 0;

  // Otherwise, copy the string and return pointer to new string
  mystrcpy(newstr, src);
  return newstr;
}
/** Duplicates a C-style string.
 @param src Pointer to string to be copied
 @param num The maximum number of elements to be copied
 @return Pointer to freshly-allocated string containing a duplicate of src
         or null if no memory is available
*/
char* mystrndup(const char* src, size_t num){
	int length;
	char* newstr;// pointer to new string to be duplicated

	length = num;//length of the new string
	newstr = (char*) malloc(length);//cast

	if (newstr ==0) return (char*) 0;// if no memory available return null
	mystrncpy(newstr, src,num);// copy the source string to the new string with a limit
	return newstr;
}
/** Measure the length of a string
 @param *string Pointer to string to be measured
 @return The length of the string
*/
size_t mystrlen (const char *string){
	size_t length = 0;//create an element counter
	//go through each elements of string, if not null, increment length
	while (*string != '\0'){
		string++;
		length++;
	}
	return length;
}
/** Copy a C string to an assigned destination
 @param *d Pointer to the destination array where the content is to be copied.
 @param *s C string to be copied
 @return d is returned
*/
char* mystrcpy(char *d, const char *s){
	char *str = d;//create a local pointer that the same as d
	while (*s){// if s is not null copy it to the new string
	*d++ = *s++;
	}
	*d = 0;
	return str;
}
/** Append a C string to an assigned destination
 @param *destination Pointer to the destination array, which should contain a C string, and be large enough to contain the concatenated resulting string
 @param *source C string to be appended
 @return d is returned
*/
char * mystrcat ( char * destination, const char * source ){
	char *strPtr = destination;// create a local destination
	while (*strPtr != '\0'){
		strPtr++;// move the pointer until it hits an empty spot
	} 
	while (*source != '\0'){//copy the source to the strPtr until source hit null
		*strPtr = *source;
		strPtr++;
		source++;
	}
	*strPtr = '\0';//make the rest of the pointer null
	return strPtr;
}
/** Append a C string to an assigned destination
 @param *destination Pointer to the destination array, which should contain a C string, and be large enough to contain the concatenated resulting string
 @param *source C string to be appended
 @param num The maximum number of elements to be appended
 @return d is returned
*/
char * mystrncat ( char * destination, const char * source, size_t num ){
	char *strPtr = destination;// create a local destination
	int i;
	while(*strPtr != '\0'){//move the pointer til it hits an empty spot
		strPtr++;
	}
	for(i=0; i<num; i++){//copy the source to the strPtr until source hit the limit or null
		if(*source != '\0'){
			*strPtr=*source;
		}
		strPtr++;
		source++;
	}
	*strPtr = '\0';//make the rest of the pointer null
	return strPtr; 

}
/** Copy a C string to an assigned destination
 @param *destination Pointer to the destination array where the content is to be copied.
 @param *source C string to be copied
 @param num The maximum number of elements to be copied
 @return d is returned
*/
char * mystrncpy ( char * destination, const char * source, size_t num ){
	char * strPtr = destination;// create a local destination
	int i;
	for (i=0;i<num;i++){//remove all the elements in strPtr
		*strPtr = '\0';
		strPtr++;
	}
	for (i=num;i>0;i--){// move the pointer back to the beginning of strPtr
		strPtr--;
	}
	
	for(i=0; i<num; i++){//copy the source until source hits null
		if(*source != '\0'){
			*strPtr = *source;
		}
		strPtr++;
		source++;

	}
	*strPtr = '\0';//make the rest of the strPtr null
	return strPtr;

}





