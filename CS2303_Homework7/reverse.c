/** Program to demonstrate string reversal
 */

#include <stdio.h>
#include <string.h>
#include <libgen.h>

/** Print usage message
 */
void usage () {
  printf("usage: reversestring \"string with characters to reverse\"\n");
  printf("   OR: reversewords \"string with words to reverse\"\n");
}

/** Reverses all the characters in a string, in place.
 * For example, "hello world" becomes "dlrow olleh"
 * @param s String to reverse.
 */

void reversestring(char* s) {
  int stringlength, i;
  char temp;
  char* head = s;
  char* tail = s;

  stringlength = strlen(s);

  for(i=0;i<stringlength-1;i++){
    tail++;
  }
  for(i=0;i<stringlength/2;i++){
    temp = *head;
    *head = *tail;
    *tail = temp;
    tail--;
    head++;
  }
  
}
/** Reverses all the characters in a word, in place.
 * For example, "hello" becomes "olleh"
 * @param s Word with chars to reverse.
 */
void reverse(char *begin, char *end){
  char temp;
  while (begin < end)
  {
    temp = *begin;
    *begin++ = *end;
    *end-- = temp;
  }

 }

/** Reverses all the words in a string, in place.
 * For example, "hello world" becomes "world hello"
 * @param s String with words to reverse.
 */
void reversewords(char* s) {
  reversestring(s);
  char* head = s;
  char* tail = s;
  char* end = s;
  int i;
  int stringlength = strlen(s);
  for(i=0;i<stringlength-1;i++){
    end++;
  }
  while(tail <= end){
    if(tail == s){
      while(*tail != ' '){
        tail++;
      }
      tail = tail-1;
      reverse(s,tail);
      head = tail+2;
      tail = head;
    }
    else if(*tail == ' '){
      tail--;
      reverse(head,tail);
      head = tail+2;
      tail = head;
    }
    else if(tail == end){
      reverse(head,tail);
      tail ++;
    }
    else{
      tail++;
    }
  }


}






/** Must take exactly one argument.
 */
int main(int argc, char* argv[]) {

  char* command; // duplicate of command name
  char* basec;    // basename of command
  char* s;       // String to reverse;

  if (argc != 2) { // Check that it was called with exactly one argument
    usage();
    return 1;
  }

  s = strdup(argv[1]); // Sring to reverse

  // See how the command was invoked

  // First strip down to just the basename, no directory prefix
  command = strdup(argv[0]);
  basec = basename(command);

  if (strcmp(basec, "reversestring") == 0) {
    printf("Original string: %s\n", s);
    reversestring(s);
    printf("Reversed string: %s\n", s);
    return 0;
  } else if (strcmp(basec, "reversewords") == 0) {
    printf("Original string: %s\n", s);
    reversewords(s);
    printf("Reversed string: %s\n", s);
    return 0;
  } else { // Those are the only two valid choices
    usage();
    return 1;
  }
}
