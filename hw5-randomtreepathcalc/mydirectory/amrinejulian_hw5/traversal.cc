#include "traversal.h"

static const string kTag = "TRAVERSAL: ";

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Homework 4 'Traversal' application class.
 *
 * This has
 *     a function to read in a tree,
 *     an outer recursive function for depth first traversal
 *     an inner recursive function for depth first traversal
 *
 * The outer function sets up the recursion. The inner function does the
 * traversal of unvisited nodes until it hits a node with no children. At that
 * point it prints out that it has found a "leaf".
 *
 * There is also a legacy function to create a tree using random numbers to
 * decide whether to connect any pair of arcs. We are not using this function.
 *
 * Author: Duncan A. Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 23 May 2016
**/

/******************************************************************************
 * Constructor
**/
Traversal::Traversal() {
}

/******************************************************************************
 * Destructor
**/
Traversal::~Traversal() {
}

/******************************************************************************
 * Accessors and Mutators
**/

/******************************************************************************
 * General functions.
**/

/******************************************************************************
 * Function 'CreateBinaryTree'.
 * We read data from the input stream and create a tree.
 *
 * Parameter:
 *     in_stream - the 'Scanner' from which to read
**/
void Traversal::CreateBinaryTree(Scanner& in_stream) {

} // void Traversal::CreateBinaryTree(Scanner& inStream)

/******************************************************************************
 * Function 'CreateTree'.
 * We read data from the input stream and create a tree.
 *
 * Parameter:
 *     in_stream - the 'Scanner' from which to read
**/
void Traversal::CreateTree() { //Scanner& in_stream) {
  MyRandom rng;
  int tree_size = rng.RandomUniformInt(24, 200);
  int children_count;
  int cost;

  for (int node_sub = 0; node_count <= tree_size; ++node_sub) {
    vector<int> children;
    cost = rng.RandomUniformInt(0, 1000);
    children_count = rng.RandomUniformInt(2, 5);

    for(int children_sub = 0; children_sub < children_count; children_sub++) {
      children.add(children_count*node_sub+children_count);
    }

    Node node = Node(node_count/children_count, node_count, cost, children, children_count);
    the_tree_.push_back(node);
  }

} // void Traversal::CreateTree(Scanner& inStream)

/******************************************************************************
 * Function 'DescendFrom'.
 *
 * This is the recursive function that is the heart of the traversal.
 *
 * We descend from a parent node passed in as a parameter.
 * if there are no children,
 *     we are at a leaf, so we test the cost against the min cost and
 *         update the min cost if appropriate
 * else
 *     for each child node
 *         visit the node, updating the current cost, and descend from it
 *
 * NOTE: On entry to this function, 'current_cost' has already been
 *       updated with the cost from 'current_node', so when we run a loop
 *       on the children of 'current_node', we need to update 'current_cost'
 *       with the cost of each child BEFORE we descend recursively.
 *
 * Parameters:
 *   blanks - the leading blank spaces so as to indent the tracing information
 *   min_cost - the running value of the min cost
 *   current_cost - the running value of the current cost
 *   start_node - the node from which to descend
**/
void Traversal::DescendFrom(string blanks, Node current_node) {
} // Traversal::DescendFrom()

/******************************************************************************
 * Function 'DoTraversalBreadthfirst'.
 *
 * To simplify matters, we output to 'log_stream'.
**/
int Traversal::DoTraversalBreadthfirst()
{
} // void Traversal::DoTraversalBreadthfirst()

/******************************************************************************
 * Function 'DoTraversalDepthfirst'.
 *
 * To simplify matters, we output to 'log_stream'.
**/
int Traversal::DoTraversalDepthfirst()
{
} // void Traversal::DoTraversalDepthfirst()

/******************************************************************************
 * Function 'ProcessFrom'.
 *
 * This is the lower level routine to do breadth first search.
**/
void Traversal::ProcessFrom()
{
} // Traversal::ProcessFrom()

/******************************************************************************
 * Function 'ReadTree'.
 * We read data from the input stream and create a tree.
 *
 * Parameter:
 *     in_stream - the 'Scanner' from which to read
**/
void Traversal::ReadTree(Scanner& in_stream)
{
} // void Traversal::ReadTree(Scanner& in_stream)

/******************************************************************************
 * Function 'ToString'.
 * This is the usual 'ToString'. We output the 'vector' of 'Node'
 * instances without regard to the order.
 *
 * Returns:
 *   a formatted 'string' version of the 'vector' of nodes
**/
string Traversal::ToString() const {
} // string Traversal::ToString() const

/******************************************************************************
 * Function 'ToStringChildren'.
 * This is a 'ToString' for a 'vector' of the child nodes.
 *
 * Returns:
 *   a formatted 'string' version of the 'vector' of the children
**/
string Traversal::ToStringChildren(string blanks, const vector<int>& children) const
{
} // string Traversal::ToStringChildren() const

/******************************************************************************
 * Function 'ToStringLog'.
 * This is a 'ToString' of logging information about the progress in the
 * search.
 *
 * Returns:
 *   a formatted 'string' version of logging information
**/
string Traversal::ToStringLog(string blanks, string label, Node the_node) const {
} // string Traversal::ToStringLog() const
