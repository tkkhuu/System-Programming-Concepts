/** mystring.h
 * @author Mike Ciaraldi
 * My own versions of some of the C-style string functions
*/

/** Duplicates a C-style string.
 @param src Pointer to string to be copied
 @return Pointer to freshly-allocated string containing a duplicate of src
         or null if no memory is available
*/


char* mystrdup(const char* src);
size_t mystrlen (const char *string);
char* mystrcpy(char *d, const char *s);

char* mystrndup(const char* src, size_t num);
char * mystrncpy ( char * destination, const char * source, size_t num );
char * mystrncat ( char * destination, const char * source, size_t num );
char * mystrcat ( char * destination, const char * source );


