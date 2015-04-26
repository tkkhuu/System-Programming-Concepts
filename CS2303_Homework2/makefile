all: at at2 at3

at2: at2.o print_arrays.o sort_arrays.o
	gcc -g at2.o print_arrays.o sort_arrays.o -o at2

at3: at3.o print_arrays.o sort_arrays.o
	gcc -g at3.o print_arrays.o sort_arrays.o -o at3

at: at.o print_arrays.o
	gcc -g  at.o print_arrays.o -o at

at3.o: at3.c print_arrays.h sort_arrays.h
	gcc -c at3.c

at2.o: at2.c print_arrays.h sort_arrays.h
	gcc -c at2.c

at.o: at.c print_arrays.h
	gcc -c at.c

sort_arrays.o: sort_arrays.c sort_arrays.h
	gcc -c sort_arrays.c

print_arrays.o: print_arrays.c print_arrays.h
	gcc -c print_arrays.c

docs:
	doxygen
	chmod go+r html/*
	cp -p html/* ~/public_html/cs2303assig2/

clean:
	rm -f *.o
	rm -f at
	rm -f at2
	rm -f at3
	rm -r -f html latex
