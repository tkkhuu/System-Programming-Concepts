/*
 * tnodetest.c
 *
 *  Created on: Feb 22, 2015
 *      Author: Tri
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include "tnode.h"
int main() {
	Tnode* node = NULL;
	Tnode* root;
	Tnode* root2;
	//---------------------------------------------------------------------------
	root = add_tnode(node, "T");//Add (pseudo)random values to a tree
	add_tnode(root, "Wst");
	add_tnode(root, "Wbsdff");
	add_tnode(root, "Jdfbdf");
	add_tnode(root, "Adsfbbdf");
	print_tree(root);
	//---------------------------------------------------------------------------
	srand(time(NULL)); // initialize to use rand()
	//Add random values to a tree
	char* string1 = stringGenerator();
	char* string2 = stringGenerator();
	char* string3 = stringGenerator();
	char* string4 = stringGenerator();
	char* string5 = stringGenerator();
	char* string6 = stringGenerator();
	char* string7 = stringGenerator();
	char* string8 = stringGenerator();
	root2 = add_tnode(node, string1);

	add_tnode(root2, string2);
	add_tnode(root2, string3);
	add_tnode(root2, string4);
	add_tnode(root2, string5);
	add_tnode(root2, string6);
	add_tnode(root2, string7);
	add_tnode(root2, string8);
	//print the tree
	print_tree(root2);

	//free the tree
	freeTnode(root2);


	return 0;
}
