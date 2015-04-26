/*
 * queuetest.c
 *
 *  Created on: Feb 22, 2015
 *      Author: Tri
 */

#include <stdlib.h>
#include <stdio.h>
#include "queue.h"

typedef struct {
	int x;
	double y;
} Foo; // Just some arbitrary struct

int main() {
	const int max_entries = MAX_ENTRIES;

	Foo* new_foo1;
	Foo* new_foo2;
	Foo* new_foo3;
	Foo* new_foo4;
	Foo* new_foo5;
	Foo* new_foo6;
	Foo* new_foo7;
	Foo* new_foo8;
	Foo* new_foo9;
	Foo* returned_foo;
	int queueoverflow;

	Queue *new_queue = create_queue(max_entries);

	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo1 = (Foo *) malloc(sizeof(Foo));
	new_foo1->x = 6;
	new_foo1->y = 14.79;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo1->x, new_foo1->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo1);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	//--------------------------------------------------------------------------------------
	new_foo2 = (Foo *) malloc(sizeof(Foo));
	new_foo2->x = 10;
	new_foo2->y = 25.34;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo2->x, new_foo2->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo2);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo3 = (Foo *) malloc(sizeof(Foo));
	new_foo3->x = 98;
	new_foo3->y = 54.39;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo3->x, new_foo3->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo3);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo4 = (Foo *) malloc(sizeof(Foo));
	new_foo4->x = 52;
	new_foo4->y = 101.45;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo4->x, new_foo4->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo4);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo5 = (Foo *) malloc(sizeof(Foo));
	new_foo5->x = 42;
	new_foo5->y = 11.355;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo5->x, new_foo5->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo5);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo6 = (Foo *) malloc(sizeof(Foo));
	new_foo6->x = 92;
	new_foo6->y = 18.5;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo6->x, new_foo6->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo6);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo7 = (Foo *) malloc(sizeof(Foo));
	new_foo7->x = 32;
	new_foo7->y = 68.5;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo7->x, new_foo7->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo7);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");

	returned_foo = peek(new_queue);
	if (returned_foo != '\0') {
		printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	}
	printf("**********************\n");


	returned_foo = dequeue(new_queue);
	returned_foo = peek(new_queue);
	printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	printf("**********************\n");

	returned_foo = dequeue(new_queue);
	returned_foo = peek(new_queue);
	printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	printf("**********************\n");

	returned_foo = dequeue(new_queue);
	returned_foo = peek(new_queue);
	printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	printf("**********************\n");

	returned_foo = dequeue(new_queue);
	returned_foo = peek(new_queue);
	printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	printf("**********************\n");

	returned_foo = dequeue(new_queue);
	returned_foo = peek(new_queue);
	printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	printf("**********************\n");

	returned_foo = dequeue(new_queue);
	returned_foo = peek(new_queue);
	if (returned_foo != '\0') {
		printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	}
	printf("**********************\n");

	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo8 = (Foo *) malloc(sizeof(Foo));
	new_foo8->x = 35;
	new_foo8->y = 70.5;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo8->x, new_foo8->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo8);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	returned_foo = peek(new_queue);
	if (returned_foo != '\0') {
		printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	}
	printf("**********************\n");

	//--------------------------------------------------------------------------------------
	// Allocate a Foo and push it onto the queue.
	new_foo9 = (Foo *) malloc(sizeof(Foo));
	new_foo9->x = 86;
	new_foo9->y = 77.35;
	printf("Enqueuing: x = %d, y = %.3f\n", new_foo9->x, new_foo9->y);
	queueoverflow = enqueue(new_queue, (void *) new_foo9);
	printf("queue overflow: %d\n", queueoverflow);
	printf(
			"//--------------------------------------------------------------------------------------\n");
	returned_foo = dequeue(new_queue);
	returned_foo = peek(new_queue);
	if (returned_foo != '\0') {
		printf("Peek: x = %d, y = %.3f\n", returned_foo->x, returned_foo->y);
	}
	printf("**********************\n");

	return 0;
}
