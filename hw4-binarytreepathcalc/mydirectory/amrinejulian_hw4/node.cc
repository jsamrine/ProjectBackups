#include "node.h"

static const string kTag = "NODE: ";

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Class 'Node' for a single node in a graph.
 *
 * Author: Duncan A. Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 15 May 2016
**/

/******************************************************************************
 * Constructor
**/
Node::Node() {
  this->parent_number_ = 0;
  this->my_number_ = 0;
  this->my_left_child_ = 0;
  this->my_right_child_ = 0;
  this->my_cost_ = 0;
  this->path_cost_
}

/******************************************************************************
 * Constructor
**/
Node::Node(int parent_number, int number,
           int left_child, int right_child, int cost) {
  this->Init(parent_number, number, left_child, right_child, cost);
}

/******************************************************************************
 * Function 'Init' to initialize a node with data.
**/
void Node::Init(int parent_number, int number,
                int left_child, int right_child, int cost) {
  this->parent_number_ = parent_number;
  this->my_number_ = number;
  this->my_left_child_ = left_child;
  this->my_right_child_ = right_child;
  this->my_cost_ = cost;
  this->path_cost_ = 0; //???
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
 * Accessor 'GetCost'.
 *
 * Returns:
 *   the cost of this node
**/
int Node::GetCost() const {
  return this->my_cost_;
}

/******************************************************************************
 * Accessor 'GetLeftChild'.
 *
 * Returns:
 *   the node number of the left child, which could be the dummy node number
**/
int Node::GetLeftChild() const {
  return this->my_left_child_;
}

/******************************************************************************
 * Accessor 'GetNodeNumber'.
 *
 * Returns:
 *   the node number of this node
**/
int Node::GetNodeNumber() const {
  return this->my_number_;
}

/******************************************************************************
 * Accessor 'GetParentNodeNumber'.
 *
 * Returns:
 *   the parent node number of this node
**/
int Node::GetParentNodeNumber() const {
  return this->parent_number_;
}

/******************************************************************************
 * Accessor 'GetPathCost'.
 *
 * Returns:
 *   the path cost of this node
**/
int Node::GetPathCost() const {
  return this->path_cost_;
}

/******************************************************************************
 * Accessor 'GetRightChild'.
 *
 * Returns:
 *   the node number of the right child, which could be the dummy node number
**/
int Node::GetRightChild() const {
  return this->my_right_child_;
}

/******************************************************************************
 * Mutator 'SetPathCost'.
 *
 * Parameter:
 *   path_cost - the value to set the current cost to
**/
void Node::SetPathCost(int path_cost) {
  this->path_cost_ = path_cost;
}

/******************************************************************************
 * General functions.
**/

/******************************************************************************
 * Function 'ToString'.
 * This returns the data, formatted, from the class.
**/
string Node::ToString() const {
  string s = "(";

  s += Utils::Format(my_number_, 4) + ": ";

  if (my_left_child_ > 0) {
    s += Utils::Format(my_left_child_, 4) + " ";
  } else {
    s += Utils::Format("XX", 4) + " ";
  }

  if (my_right_child_ > 0) {
    s += Utils::Format(my_right_child_, 4) + " ";
  } else {
    s += Utils::Format("XX", 4) + " ";
  }

  s += Utils::Format(my_cost_, 4);

  s += Utils::Format(path_cost_, 4);

  s += ")";

  return s;
}
