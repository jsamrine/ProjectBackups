#include "node.h"

static const string kTag = "NODE: ";

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Class 'Node' for a single node in a graph.
 *
 * This class is essentially just a wrapper for:
 *   a node sequence number
 *   a 'bool' variable called 'visited' to indicate whether the node has been
 *       visited or not
 *   a pair of 'int' values for the node numbers of the left and right
 *       children
 *   an 'int' cost to traverse this node
 *
 * Author: Duncan A. Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 23 May 2016
**/

/******************************************************************************
 * Constructor
**/
Node::Node() {
}

/******************************************************************************
 * Constructor -- we use this for creating the tree file.
Node::Node(int number, int cost, const vector<int>& children, int node_count) {
  this->Init(number, cost, children, node_count);
}
**/

/******************************************************************************
 * Constructor -- we use this for creating the tree file.
**/
Node::Node(int parent_number, int number, int cost,
           const vector<int>& children, int node_count) {
  this->Init(parent_number, number, cost, children, node_count);
}

/******************************************************************************
 * Function 'Init' to initialize a node with data.
**/
void Node::Init(int parent_number, int number, int cost,
                const vector<int>& children, int node_count) {
  this->parent_number_ = parent_number;
  this->my_number_ = number;
  this->my_cost_ = cost;
  this->my_children_ = children;
  //node_count

}

/******************************************************************************
 * Destructor
**/
Node::~Node() {
}

/******************************************************************************
 * Accessors and Mutators
**/

/******************************************************************************
 * Accessor 'GetChildren'.
 *
 * Returns:
 *   the 'vector' of children of this node
**/
vector<int> Node::GetChildren() const {
  return my_children_;
}

/******************************************************************************
 * Accessor 'GetCost'.
 *
 * Returns:
 *   the cost of this node
**/
int Node::GetCost() const {
  return my_cost_;
}

/******************************************************************************
 * Accessor 'GetNodeNumber'.
 *
 * Returns:
 *   the node number of this node
**/
int Node::GetNodeNumber() const {
  return my_number_;
}

/******************************************************************************
 * Accessor 'GetParentNodeNumber'.
 *
 * Returns:
 *   the parent node number of this node
**/
int Node::GetParentNodeNumber() const {
  return parent_number_;
}

/******************************************************************************
 * Accessor 'GetPathCostBreadthfirst'.
 *
 * Returns:
 *   the path cost of this node as computed by breadth first search
**/
int Node::GetPathCostBreadthfirst() const {
  return path_cost_breadthfirst_;
}

/******************************************************************************
 * Accessor 'GetPathCostDepthfirst'.
 *
 * Returns:
 *   the path cost of this node as computed by depth first search
**/
int Node::GetPathCostDepthfirst() const {
  return path_cost_depthfirst_;
}

/******************************************************************************
 * Accessor 'GetPathCostGenerate'.
 *
 * Returns:
 *   the path cost of this node as computed when the nodes were generated
**/
int Node::GetPathCostGenerate() const {
  return path_cost_generate_;
}

/******************************************************************************
 * Mutator 'SetPathCostBreadthfirst'.
 *
 * Parameter:
 *   what - the value to add to the current cost
**/
void Node::SetPathCostBreadthfirst(int path_cost) {
  this->path_cost_breadthfirst_ = path_cost;
}

/******************************************************************************
 * Mutator 'SetPathCostDepthfirst'.
 *
 * Parameter:
 *   what - the value to add to the current cost
**/
void Node::SetPathCostDepthfirst(int path_cost) {
  this->path_cost_depthfirst_ = path_cost;
}

/******************************************************************************
 * Mutator 'SetPathCostGenerate'.
 *
 * Parameter:
 *   what - the value to add to the current cost
**/
void Node::SetPathCostGenerate(int path_cost) {
  this->path_cost_generate_ = path_cost;
}

/******************************************************************************
 * General functions.
**/
/******************************************************************************
 * Function to add to the path cost in the generation of nodes.
 *
 * Parameter:
 *   the cost to be added to 'path_cost_generate_'
**/
void Node::AddToPathCostGenerate(int cost_to_add) {
  
}

/******************************************************************************
 * Function 'ToString'.
 * This returns the data, formatted, from the class.
**/
string Node::ToString() const {
  string s = "";
  string s = "(";

  s += Utils::Format(my_number_, 4) + ": ";

  for(auto iter = my_children_.begin(); iter != my_children_.end(); ++iter) {
    s+= Utils::Format(iter*, 4) + " ";
  }

  s += Utils::Format(my_cost_, 4);

  s += Utils::Format(path_cost_, 4);

  s += ")";

  return s;

}
