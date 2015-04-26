/*
 * tnode.c
 *
 *  Created on: Feb 22, 2015
 *      Author: Tri
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "tnode.h"
/** Add a node to an empty node, if the node pointed is null, allocate a new node
 * and return a pointer to the new allocated node, if not compare it to its parent and put
 * it in the left or right child
 * @param current_tnode Pointer to an existing node to be added to
 * @param value A C-style string as the data for the new node
 * @return The pointer to the node added
 *
 */

Tnode *add_tnode(Tnode *current_tnode, char* value) {
	if (current_tnode == NULL) { //if the pointer passed is null, allocate a memory space for it
		return createNode(value);
	} else { //if the node passed in is available
		int compare = strcmp(value, (current_tnode)->data); //compare the data with the parent data
		if (compare < 0) { //if the new node is smaller than the passed in node, add to the left of the parent
			if (current_tnode->left == NULL) { //if left child is NULL, allocate a memory for it
				current_tnode->left = createNode(value);
				return current_tnode->left;
			} else {
				return add_tnode(current_tnode->left, value); //if not recursively compare to its children
			}
		} else if (compare > 0) { //if the new node is larger than the passed in node, add to the right of the parent
			if (current_tnode->right == NULL) { //if right child is NULL, allocate a memory for it
				current_tnode->right = createNode(value);
				return current_tnode->right;
			} else {
				return add_tnode(current_tnode->right, value); //if not recursively compare to its children
			}
		} else { //if the new node is equal to the passed in node, don't add it
			printf("data was not added because it exists in the Tree\n");
			return NULL;
		}
	}
}

/** Helper function to allocate a new memory for a new node
 * @param value Data of the new node to be created
 * @return The pointer to the new node created
 */
Tnode* createNode(char *value) {
	Tnode* newNode = (Tnode*) malloc(sizeof(Tnode));
	if (newNode != NULL) {
		newNode->data = value;
		newNode->left = NULL;
		newNode->right = NULL;
	}
	return newNode;
}

/**	Function to print a tree in different formats: in order, pre order, post order
 *	@param which_tree Pointer to the tree to be pointed
 */
void print_tree(Tnode *which_tree) {
	printf("Print in order\n");
	printInOrder(which_tree); //print in order
	printf("Print pre order\n");
	printPreOrder(which_tree); //print pre order
	printf("Print post order\n");
	printPostOrder(which_tree); //print post order
}

/** Function to print a tree in the format: in order
 *	@param which_tree Pointer to the tree to be printed
 */
void printInOrder(Tnode* which_tree) {
	if (which_tree != NULL) {
		printInOrder(which_tree->left); //print left
		printf("%s\n", which_tree->data); //print the data
		printInOrder(which_tree->right); //print right child

	}
}

/** Function to print a tree in the format: pre order
 *	@param which_tree Pointer to the tree to be printed
 */
void printPreOrder(Tnode* which_tree) {
	if (which_tree != NULL) {
		printf("%s\n", which_tree->data); //print data
		printPreOrder(which_tree->left); //print left child
		printPreOrder(which_tree->right); //print right child
	}
}

/** Function to print a tree in the format: post order
 *	@param which_tree Pointer to the tree to be printed
 */
void printPostOrder(Tnode* which_tree) {
	if (which_tree != NULL) {
		printPostOrder(which_tree->left); //print left child
		printPostOrder(which_tree->right); //print right child
		printf("%s\n", which_tree->data); //print data
	}
}

/** Function to traverse a tree and free all the nodes
 *	@param root Pointer to the root of a tree to be freed
 */
void freeTnode(Tnode *root) {
	if (root == NULL) {
		return;
	}
	freeTnode(root->left);
	freeTnode(root->right);
	free(root);
}

/** Generate a random string
 @return A string with random size and value
 */
char* stringGenerator() {
	int size, i;
	size = rand() % 3; // create a random string with a random size less than or equal to the size of the name field
	char* strArr;
	strArr = (char*) malloc(100 * sizeof(char)); //malloc the array
	char alphabet[] =
			"0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"; //array store all the alphabet symbols and numeric symbols
	//fill the array up
	for (i = 0; i < size; i++) {
		strArr[i] = alphabet[rand() % (sizeof(alphabet) - 1)];
	}
	return strArr;
}
