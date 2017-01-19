#include "traversal.h"

static const string kTag = "TRAVERSAL: ";

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Homework 4 'Traversal' application class.
 *
 * Author: Duncan A. Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 17 May 2016
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
 * Function 'CreateTree'.
 * We read data from the input stream and create a tree.
 *
 * Parameter:
 *     in_stream - the 'Scanner' from which to read
**/
void Traversal::CreateBinaryTree(Scanner& in_stream)
{
  int node_count;
  MyRandom my_random;
#ifdef EBUG
  Utils::log_stream << kTag << "enter CreateBinaryTree\n";
#endif

  if (in_stream.HasNext()) {
    node_count = in_stream.NextInt();
    if (node_count <= 0) {
      Utils::log_stream << kTag << "ERROR: tree must have nonzero node count\n";
      exit(0);
    }
  } else {
    Utils::log_stream << kTag << "ERROR: no data to read\n";
    exit(0);
  }

  Utils::log_stream << kTag << "Create a binary tree of " << node_count
                    << " nodes with node weights " << endl;

  // We create the vector of empty nodes.
  // Note that we count up less equal 'node_count'.
  // We are going to ignore completely the zero-subscript node.
  for (int node_sub = 0; node_sub <= node_count; ++node_sub) {
    int cost = my_random.RandomUniformInt(0, 100);
    int left_child = kDummyNumber;
    int right_child = kDummyNumber;
    if (node_sub*2 + 1 <= node_count) {
      right_child = node_sub*2 + 1;
    }
    if (node_sub*2 <= node_count) {
      left_child = node_sub*2;
    }
    Node node = Node(node_sub/2, node_sub, left_child, right_child, cost);
    if (node_sub > 1) {
      node.SetPathCost(node.GetCost() +
                       the_tree_.at(node_sub/2).GetPathCost());
    } else if (1 == node_sub) {
      node.SetPathCost(node.GetCost());
    }
    the_tree_.push_back(node);
  }

#ifdef EBUG
  Utils::log_stream << kTag << "leave CreateBinaryTree " << node_count << endl;
  Utils::log_stream << kTag << "Tree is " << endl;
  Utils::log_stream << this->ToString() << endl;
#endif
} // void Traversal::CreateBinaryTree(Scanner& inStream)

/******************************************************************************
 * Function 'DescendFrom'.
 *
 * This is the recursive function that is the heart of the traversal.
 *
**/
void Traversal::DescendFrom(string blanks, int& min_cost, int& current_cost,
                            Node current_node) {
#ifdef EBUG
  Utils::log_stream << blanks << kTag << "enter DescendFrom"
       << current_node.ToString() << endl;
#endif
  //traverse left, print, traverse right
#ifdef EBUG
  Utils::log_stream << blanks << kTag << "leave DescendFrom\n";
#endif

} // Traversal::DescendFrom()

/******************************************************************************
 * Function 'DoTraversal'.
 *
 * To simplify matters, we output to 'log_stream'.
 *
 * Parameter:
 *   log_stream -- the output stream to which to write
**/
int Traversal::DoTraversal() {
#ifdef EBUG
  Utils::log_stream << kTag << "enter DoTraversal\n";
#endif

  // We start with node 1 as the root (and not node 0!).
  // We descend and keep track of the running cost.
  int node_sub = 1; // start with node 1, and this isn't magic

#ifdef EBUG
  Utils::log_stream << kTag << "leave DoTraversal\n";
#endif

  return min_cost;

} // void Traversal::DoTraversal()

/******************************************************************************
 * Function 'ReadTree'.
 * We read data from the input stream and create a tree.
 *
 * Parameter:
 *     in_stream - the 'Scanner' from which to read
**/
void Traversal::ReadTree(Scanner& in_stream)
{
  int node_count;
  string line = "";
  ScanLine scanline;

#ifdef EBUG
  Utils::log_stream << kTag << "enter ReadTree\n";
#endif
  if (in_stream.HasNext()) {
    node_count = static_cast<int>(in_stream.NextInt());
  }

  the_tree_.reserve(node_count);

  while (in_stream.HasNext()) {
    int number = in_stream.NextInt();
    if (in_stream.HasNext()) {
      int this_left_child = in_stream.NextInt();
    } else { }
    if (in_stream.HasNext()) {
      int this_right_child = in_stream.NextInt();
    } else { }
    if (in_stream.HasNext()) {
      int this_cost = in_stream.NextInt();
    } else { }

    Node new_node = Node(this_number/2, this_number, this_left_child,
                         this_right_child, this_cost);
    the_tree_.push_back(new_node);
  }



#ifdef EBUG
  Utils::log_stream << kTag << "leave ReadTree " << endl;
#endif
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
  string s = "";
#ifdef EBUG
  Utils::log_stream << kTag << "enter ToString\n";
#endif

  if (0 == the_tree_.size()) {
    s += "There are no nodes\n";
  } else {
    for(auto iter = the_tree_.begin(); iter != the_tree_.end(); ++iter) {
      s += "Node " + (*iter).ToString();
      s += "\n";
    }
    s += "\n";
  }

#ifdef EBUG
  Utils::log_stream << kTag << "leave ToString\n";
#endif
  return s;
} // string Traversal::ToString() const

/******************************************************************************
 * Function 'ToStringChildren'.
 * This is a 'ToString' for a 'vector' of the child nodes.
 *
 * Returns:
 *   a formatted 'string' version of the 'vector' of the children
**/
string Traversal::ToStringChildren(string blanks,
                                   const vector<int>& children) const {
  string s = "";
#ifdef EBUG
  Utils::log_stream << kTag << "enter ToStringChildren\n";
#endif

  if (0 == children.size()) {
    s += blanks;
    s += "There are no children\n";
  } else {
    for(auto iter = children.begin(); iter != children.end(); ++iter) {
      s += blanks;
      s += Utils::Format(*iter, 4);
    }
    s += "\n";
  }

#ifdef EBUG
  Utils::log_stream << kTag << "leave ToStringChildren\n";
#endif
  return s;
} // string Traversal::ToStringChildren() const
