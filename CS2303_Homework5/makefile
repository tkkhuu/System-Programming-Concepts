all: stacktest queuetest tnodetest

stacktest: stacktest.o stack.o
	gcc -g stacktest.o stack.o -o stacktest
	
queuetest: queuetest.o queue.o
	gcc -g queuetest.o queue.o -o queuetest
	
tnodetest: tnodetest.o tnode.o
	gcc -g tnodetest.o tnode.o -o tnodetest

stack.o: stack.c stack.h
	gcc -g -c stack.c
	
queue.o: queue.c queue.h
	gcc -g -c queue.c
	
tnode.o: tnode.c tnode.h
	gcc -g -c tnode.c

stacktest.o: stacktest.c stack.h
	gcc -g -c stacktest.c
	
queuetest.o: queuetest.c queue.h
	gcc -g -c queuetest.c
	
tnodetest.o: tnodetest.c tnode.h
	gcc -g -c tnodetest.c

docs:
	doxygen
	chmod a+r html/*
	cp -p html/* ~/public_html/cs2303assig5

clean:
	rm -f *.o
	rm -f stacktest
	rm -f queuetest
	rm -f tnodetest
