/****************************************************************
 * Header file for a node in a graph.
 *
 * Author/copyright:  Duncan Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 23 May 2016
**/

#ifndef NODE_H
#define NODE_H

#include <iostream>
#include <vector>
using namespace std;

#include "../../Utilities/scanner.h"
#include "../../Utilities/scanline.h"

static const int kDummyCost = -999;
static const int kDummyNodeNumber = -99;

class Node {
public:
 Node();
// Node(int number, int cost, const vector<int>& children, int node_count);
 Node(int parent_number, int number, int cost,
      const vector<int>& children, int node_count);
 virtual ~Node();

 vector<int> GetChildren() const;

 void AddToPathCostGenerate(int cost_to_add);
 int GetCost() const;
 int GetNodeNumber() const;
 int GetParentNodeNumber() const;
 int GetPathCostBreadthfirst() const;
 int GetPathCostDepthfirst() const;
 int GetPathCostGenerate() const;
 void SetPathCostBreadthfirst(int path_cost_to_here);
 void SetPathCostDepthfirst(int path_cost_to_here);
 void SetPathCostGenerate(int path_cost_to_here);

 string ToString() const;

private:
 int my_cost_;
 int my_number_;
 int parent_number_;
 int path_cost_breadthfirst_;
 int path_cost_depthfirst_;
 int path_cost_generate_;

 vector<int> my_children_;

// void Init (int number, int cost, const vector<int>& children, int node_count);
 void Init (int parent_number, int number, int cost,
            const vector<int>& children, int node_count);
};

#endif
