all: cptest cptest1 cptest2

cptest: cptest.o copy.o
	gcc -g cptest.o copy.o -o cptest
	
cptest1: cptest1.o copy.o
	gcc -g cptest1.o copy.o -o cptest1
	
cptest2: cptest2.o copy.o
	gcc -g cptest2.o copy.o -o cptest2

cptest.o: cptest.c cptest.h
	gcc -c -g cptest.c
	
cptest1.o: cptest1.c cptest.h
	gcc -c -g cptest1.c
	
cptest2.o: cptest2.c cptest.h
	gcc -c -g cptest2.c
	
copy.o: copy.c cptest.h
	gcc -c -g copy.c

clean:
	rm -f *.o cptest
	rm -f *.o cptest1

docs:
	doxygen
	chmod a+r html/*
	cp -p html/* ~/public_html/cs2303assig6


