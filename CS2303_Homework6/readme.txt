Name: Tri Khuu:
Username: tkkhuu

LIST OF FILES
cptest.c			- contains the source code for assignment 6 section B Part 1-6

cptest1.c			- contains the source code for assignment 6 section B Part 7
cptest2.c			- contains the source code for assignment 4 section B Part 8


copy.c				- contains source code for all the functions

cptest.h			- contains the function prototypes defined in cptest.c

Doxyfile			- contains the information to create the doxygen file

makefile			- file to compile the program


INSTRUCTION FOR COMPILING CODE
type "make" into the command line to compile the code

INSTRUCTION FOR RUNNING CODE
type ./cptest
type ./cptest1
type ./cptest2

TEST DATA
//——————————————cptest——————————————
-bash-3.2$ ./cptest ~/My_Documents/Tri/ ~/testresources/ copyfile2
In base: /home/tkkhuu/My_Documents/Tri/
In file name is: /home/tkkhuu/My_Documents/Tri//RISE
concat outfile /home/tkkhuu/testresources//RISE
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/list of courses.pdf
concat outfile /home/tkkhuu/testresources//RISE/list of courses.pdf
copyfile2 was used to perform copying
Start Time: 1425358638 seconds, 580257 microseconds
End Time: 1425358638 seconds, 972141 microseconds
Total Run Time: 0 seconds, 391884 microseconds
Total Run Time in Decimal: 0.391884
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/german intern cover letter Hannover.docx
concat outfile /home/tkkhuu/testresources//RISE/german intern cover letter Hannover.docx
copyfile2 was used to perform copying
Start Time: 1425358638 seconds, 985894 microseconds
End Time: 1425358639 seconds, 59884 microseconds
Total Run Time: 0 seconds, 73989 microseconds
Total Run Time in Decimal: 0.073990
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/german intern cover letter.docx
concat outfile /home/tkkhuu/testresources//RISE/german intern cover letter.docx
copyfile2 was used to perform copying
Start Time: 1425358639 seconds, 73387 microseconds
End Time: 1425358639 seconds, 136996 microseconds
Total Run Time: 0 seconds, 63608 microseconds
Total Run Time in Decimal: 0.063609
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/german intern cover letter Tuebin.docx
concat outfile /home/tkkhuu/testresources//RISE/german intern cover letter Tuebin.docx
copyfile2 was used to perform copying
Start Time: 1425358639 seconds, 149067 microseconds
End Time: 1425358639 seconds, 218930 microseconds
Total Run Time: 0 seconds, 69863 microseconds
Total Run Time in Decimal: 0.069863
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/IQP Resume.docx
concat outfile /home/tkkhuu/testresources//RISE/IQP Resume.docx
copyfile2 was used to perform copying
Start Time: 1425358639 seconds, 229649 microseconds
End Time: 1425358639 seconds, 291699 microseconds
Total Run Time: 0 seconds, 62050 microseconds
Total Run Time in Decimal: 0.062050
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/list of courses.docx
concat outfile /home/tkkhuu/testresources//RISE/list of courses.docx
copyfile2 was used to perform copying
Start Time: 1425358639 seconds, 310447 microseconds
End Time: 1425358639 seconds, 373613 microseconds
Total Run Time: 0 seconds, 63166 microseconds
Total Run Time in Decimal: 0.063166
In base: /home/tkkhuu/My_Documents/Tri/
In file name is: /home/tkkhuu/My_Documents/Tri//~$Resume.docx
concat outfile /home/tkkhuu/testresources//~$Resume.docx
copyfile2 was used to perform copying
Start Time: 1425358639 seconds, 378641 microseconds
End Time: 1425358639 seconds, 379387 microseconds
Total Run Time: 0 seconds, 746 microseconds
Total Run Time in Decimal: 0.000746
In base: /home/tkkhuu/My_Documents/Tri/
In file name is: /home/tkkhuu/My_Documents/Tri//Resume.docx
concat outfile /home/tkkhuu/testresources//Resume.docx
copyfile2 was used to perform copying
Start Time: 1425358639 seconds, 395157 microseconds
End Time: 1425358639 seconds, 461566 microseconds
Total Run Time: 0 seconds, 66409 microseconds
Total Run Time in Decimal: 0.066409
//****************************End stest****************************
//———————————————cptest2-----------------------------
-bash-3.2$ ./cptest1 ~/My_Documents/Tri/ ~/testresources/ -c copyfile2 -b 1024
In base: /home/tkkhuu/My_Documents/Tri/
In file name is: /home/tkkhuu/My_Documents/Tri//RISE
concat outfile /home/tkkhuu/testresources//RISE
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/list of courses.pdf
concat outfile /home/tkkhuu/testresources//RISE/list of courses.pdf
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 243461 microseconds
End Time: 1425358695 seconds, 245188 microseconds
Total Run Time: 0 seconds, 1727 microseconds
Total Run Time in Decimal: 0.001727
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/german intern cover letter Hannover.docx
concat outfile /home/tkkhuu/testresources//RISE/german intern cover letter Hannover.docx
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 251301 microseconds
End Time: 1425358695 seconds, 251623 microseconds
Total Run Time: 0 seconds, 322 microseconds
Total Run Time in Decimal: 0.000322
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/german intern cover letter.docx
concat outfile /home/tkkhuu/testresources//RISE/german intern cover letter.docx
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 256007 microseconds
End Time: 1425358695 seconds, 256284 microseconds
Total Run Time: 0 seconds, 277 microseconds
Total Run Time in Decimal: 0.000277
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/german intern cover letter Tuebin.docx
concat outfile /home/tkkhuu/testresources//RISE/german intern cover letter Tuebin.docx
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 260311 microseconds
End Time: 1425358695 seconds, 260612 microseconds
Total Run Time: 0 seconds, 301 microseconds
Total Run Time in Decimal: 0.000301
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/IQP Resume.docx
concat outfile /home/tkkhuu/testresources//RISE/IQP Resume.docx
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 264787 microseconds
End Time: 1425358695 seconds, 265065 microseconds
Total Run Time: 0 seconds, 278 microseconds
Total Run Time in Decimal: 0.000278
In base: /home/tkkhuu/My_Documents/Tri//RISE
In file name is: /home/tkkhuu/My_Documents/Tri//RISE/list of courses.docx
concat outfile /home/tkkhuu/testresources//RISE/list of courses.docx
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 270248 microseconds
End Time: 1425358695 seconds, 270527 microseconds
Total Run Time: 0 seconds, 279 microseconds
Total Run Time in Decimal: 0.000279
In base: /home/tkkhuu/My_Documents/Tri/
In file name is: /home/tkkhuu/My_Documents/Tri//~$Resume.docx
concat outfile /home/tkkhuu/testresources//~$Resume.docx
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 274664 microseconds
End Time: 1425358695 seconds, 274703 microseconds
Total Run Time: 0 seconds, 39 microseconds
Total Run Time in Decimal: 0.000039
In base: /home/tkkhuu/My_Documents/Tri/
In file name is: /home/tkkhuu/My_Documents/Tri//Resume.docx
concat outfile /home/tkkhuu/testresources//Resume.docx
copyfile1 was used by default to perform copying
Start Time: 1425358695 seconds, 278489 microseconds
End Time: 1425358695 seconds, 278768 microseconds
Total Run Time: 0 seconds, 279 microseconds
Total Run Time in Decimal: 0.000279
-bash-3.2$ 
//****************************End stest2****************************
