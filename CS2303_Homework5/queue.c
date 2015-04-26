#include <stdlib.h>
#include <stdio.h>
#include "queue.h"

//						--------------------
//		base---->		-------Value2-------
//						-------Value3-------
//						---------------			<----next
//						---------------

//-----------------------------------Queue-----------------------------------
/** Create a queue by allocating a Queue structure, initializing it,
 *  and allocating memory to hold the Queue entries.
 * @param max_cells Maximum entries in the queue
 * @return Pointer to newly-allocated queue structure, NULL if error.
 */

Queue *create_queue(int max_cells) {
	Queue *new_queue; // Holds pointer to the newly-allocated Queue structure.
	new_queue = (Queue *) malloc(sizeof(Queue));

	if (new_queue == NULL)
		return NULL; // Error--unable to allocate.

	// Fill in the struct
	new_queue->max_cells = max_cells;
	new_queue->cells_used = 0; // Empty to start
	new_queue->nextPosition = 1;
	new_queue->headposition = 1;
	// Now allocate space for the queue entries.
	new_queue->queue_base = (void **) calloc(sizeof(void *), max_cells);
	if (new_queue->queue_base == NULL) {
		free(new_queue); // Unable to allocate queue entries, so free struct.
		return NULL;
	}
	new_queue->tail = new_queue->queue_base; // Start at base
	new_queue->head = new_queue->queue_base;
	return new_queue;
}

//-----------------------------------Enqueue-----------------------------------

/** Add a pointer to a Queue.
 * @param which_queue Pointer to queue you want to add to.
 * @param ptr Pointer to be added.
 * @return 0 if successful, -1 if not.
 */
int enqueue(Queue *which_queue, void *ptr) {
	// Check if stack is already full
	if (which_queue->cells_used == 0) {
		*(which_queue->queue_base) = ptr;
		*(which_queue->head) = ptr;
	}
	if ((which_queue->cells_used) < (which_queue->max_cells)) {
		// Add to queue.
		*(which_queue->tail) = ptr;  // Store the pointer on the stack


		if (which_queue->nextPosition == MAX_ENTRIES) {
			which_queue->nextPosition = 1;
			(which_queue->cells_used)++;
			which_queue->tail = which_queue->queue_base;       // Point to next free cell
		} else {
			(which_queue->cells_used)++;
			(which_queue->tail)++;       // Point to next free cell
			which_queue->nextPosition++;
		}
		printf("Enqueue: enqueue succeeded, cell used: %d\n", which_queue->cells_used);
		return 0;  // Success
	} else {
		which_queue->cells_used = which_queue->max_cells; // Fix
		printf("Enqueue: queue overflow, cell used: %d\n", which_queue->cells_used);
		return -1;  // Queue overflow.
	}

}

//-----------------------------------Dequeue-----------------------------------

/** Dequeue bottom of queue, and returns it.
 * @param which_queue Pointer to Queue you want to dequeue from.
 * @return Bottom entry of the queue, NULL if queue is empty.
 */
void* dequeue(Queue *which_queue) {
	void **currentbase;
	// Check if queue is empty
	if ((which_queue->cells_used) < 1) {
		printf("Dequeue: The queue is empty\n");
		currentbase = NULL;  // Stack empty
	} else {
		// dequeue from queue.
		(which_queue->cells_used)--;
		currentbase = which_queue->head;
		if(which_queue->headposition == MAX_ENTRIES){
			which_queue->headposition = 1;
			(which_queue->head) = which_queue->queue_base;
		}
		else{
			(which_queue->head)++;
			which_queue->headposition++;
		}
		printf("Dequeue: dequeue succeeded, cell used: %d\n", which_queue->cells_used);

	}
	return (*(currentbase));
}
//-----------------------------------Peek-----------------------------------

/** Peek at bottom of queue, without popping
 * @param which_queue Pointer to Queue you want to peek into
 * @return Bottom entry of the queue, NULL if queue is empty.
 */
void* peek(Queue *which_queue) {
	// Check if queue is empty
	if ((which_queue->cells_used) < 1) {
		printf("Peek: cell used: %d\n", which_queue->cells_used);
		printf("Peek: the stack is empty\n");
		return NULL;  // Stack empty
	}

	//Return bottom of queue, without popping.
	//Remember, 'next' points to next free cell
	else {
		printf("Peek: cell used: %d\n", which_queue->cells_used);
		return (*(which_queue->head)); // Get the entry
	}
}
