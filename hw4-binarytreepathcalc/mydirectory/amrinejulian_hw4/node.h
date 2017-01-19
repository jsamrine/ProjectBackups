/****************************************************************
 * Header file for a node in a graph.
 *
 * Author/copyright:  Duncan Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 15 May 2016
**/

#ifndef NODE_H
#define NODE_H

#include <iostream>
#include <vector>
using namespace std;

#include "../../Utilities/scanner.h"
#include "../../Utilities/scanline.h"

static const int kDummyCost = -999;
static const int kDummyNumber = -99;

class Node {
public:
 Node();
 Node(int parent_number, int number,
      int left_child, int right_child, int cost);
 virtual ~Node();

 int GetCost() const;
 int GetLeftChild() const;
 int GetNodeNumber() const;
 int GetParentNodeNumber() const;
 int GetPathCost() const;
 int GetRightChild() const;
 void SetPathCost(int path_cost_to_here);

 string ToString() const;

private:
 int my_cost_;
 int my_left_child_;
 int my_number_;
 int parent_number_;
 int my_right_child_;
 int path_cost_;

 void Init (int parent_number, int number,
            int left_child, int right_child, int cost);
};

#endif
