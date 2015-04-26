/*
 * queue.h
 *
 *  Created on: Feb 22, 2015
 *      Author: Tri
 */

#ifndef QUEUE_H_
#define QUEUE_H_
#define MAX_ENTRIES 6
struct queue {
	void **queue_base; // Pointer to base of stack
	void **head;
	void **tail;  // Pointer to next free cell;
	int max_cells; // Maximum number of entries in the stack
	int cells_used; // Currently used number of cells
	int nextPosition; //Position of the next pointer on the queue
	int headposition;
};

typedef struct queue Queue;	// First In, First Out

Queue *create_queue(int max_cells);
int enqueue(Queue *which_queue, void *ptr);
void* dequeue(Queue *which_queue);
void* peek(Queue *which_queue);

#endif /* QUEUE_H_ */
