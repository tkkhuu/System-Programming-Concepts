/*
 * tnode.h
 *
 *  Created on: Feb 22, 2015
 *      Author: Tri
 */

#ifndef TNODE_H_
#define TNODE_H_

struct tnode {
	char *data;
	struct tnode *left;
	struct tnode *right;
};
typedef struct tnode Tnode;
Tnode *add_tnode(Tnode *current_tnode, char* value);
void print_tree(Tnode *which_tree);
void printInOrder(Tnode* which_tree);
void printPreOrder(Tnode* which_tree);
void printPostOrder(Tnode* which_tree);
Tnode* createNode(char *value);
char* stringGenerator();
void freeTnode(Tnode *root);
#endif /* TNODE_H_ */
