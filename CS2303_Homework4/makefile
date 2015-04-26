all: stest stest2 stest3 stest4 stest5

stest: stest.o struct.o
	gcc -g stest.o struct.o -lreadline -lncurses -o stest

stest2: stest2.o struct.o
	gcc -g stest2.o struct.o -lreadline -lncurses -o stest2
	
stest3: stest3.o struct.o
	gcc -g stest3.o struct.o -lreadline -lncurses -o stest3
	
stest4: stest4.o struct.o
	gcc -g stest4.o struct.o -lreadline -lncurses -o stest4
	
stest5: stest5.o struct.o
	gcc -g stest5.o struct.o -lreadline -lncurses -o stest5

stest.o: stest.c struct.h
	gcc -g -D DEBUG  -c stest.c
	
stest2.o: stest2.c struct.h
	gcc -g -c stest2.c

stest3.o: stest3.c struct.h
	gcc -g -c stest3.c
	
stest4.o: stest4.c struct.h
	gcc -g -c stest4.c
	
stest5.o: stest5.c struct.h
	gcc -g -c stest5.c

struct.o: struct.c struct.h
	gcc -g -c struct.c
	
stestdebug: stestdebug.o
	gcc -g stestdebug.o -o stestdebug

stestdebug.o: stest.c struct.h
	gcc -g -c stest.c -o stestdebug.o 

clean:
	rm -f *.o stest stest2 stest3 stest4 stest5 stestebug

docs:
	doxygen
	chmod a+r html/*
	cp -p html/* ~/public_html/cs2303assig4

