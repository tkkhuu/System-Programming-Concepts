ctest: ctest.o mystring.o employee.o
	gcc ctest.o mystring.o employee.o -o ctest

ctest.o: ctest.c mystring.h employee.h
	gcc -c ctest.c

mystring.o: mystring.c mystring.h employee.h
	gcc -c mystring.c

employee.o: employee.c mystring.h employee.h
	gcc -c employee.c

docs: 
	doxygen
	chmod go+r html/*
	cp -p html/* ~/public_html/cs2303assig2/

clean: 
	rm -f mystring.o ctest.o ctest employee.o

