/****************************************************************
 * Homework 4 header file for the application class.
 *
 * Author/copyright:  Duncan Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 15 May 2016
**/

#ifndef TRAVERSAL_H
#define TRAVERSAL_H

#include <iostream>
#include <vector>
using namespace std;

#include "../../Utilities/utils.h"
#include "../../Utilities/scanner.h"
#include "../../Utilities/scanline.h"

#include "node.h"
#include "myrandom.h"

class Traversal {
public:
 Traversal();
 virtual ~Traversal();

 void CreateBinaryTree(Scanner& in_stream);
 void CreateTree(Scanner& in_stream);
 void DescendFrom(string blanks, Node from_node);
 int DoTraversalBreadthfirst();
 int DoTraversalDepthfirst();
 void ProcessFrom();
 void ReadTree(Scanner& in_stream);
 string ToString() const;

private:
 int min_cost_;

 vector<int> breadthfirst_nodelist_;
 vector<Node> the_tree_;

 string ToStringChildren(string blanks, const vector<int>& children) const;
 string ToStringLog(string blanks, string label, Node the_node) const;
};

#endif
