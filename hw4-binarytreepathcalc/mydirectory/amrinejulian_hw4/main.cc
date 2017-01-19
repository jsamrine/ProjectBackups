#include "main.h"

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Homework 4 main program.
 *
 * This program reads nodes, their cost, and their child links, and
 * creates and traverses the graph with those nodes to determine the min cost.
 *
 * Author: Duncan A. Buell
 * Used with permission and modified by: Julian Amrine
 * Date: 15 May 2016
**/

int main(int argc, char *argv[]) {
  string in_filename = "";
  string out_filename = "";
  string log_filename = "";
  ofstream out_stream;

  Scanner in_stream;

  Traversal traversal;

  Utils::CheckArgs(3, argc, argv, "infilename outfilename logfilename");
  in_filename = static_cast<string>(argv[1]); // DO NOT USE OLD CAST!
  out_filename = static_cast<string>(argv[2]);
  log_filename = static_cast<string>(argv[3]);

  Utils::LogFileOpen(log_filename);

  Utils::log_stream << "Beginning execution\n";
  Utils::log_stream.flush();

  Utils::FileOpen(out_stream, out_filename);

  Utils::log_stream << "infile  '" << in_filename << "'\n";
  Utils::log_stream << "outfile '" << out_filename << "'\n";
  Utils::log_stream << "logfile '" << log_filename << "'\n";

  in_stream.OpenFile(in_filename);
//  traversal.CreateBinaryTree(in_stream);
  traversal.ReadTree(in_stream);
  in_stream.Close();

  out_stream << "RAW TREE\n" << traversal.ToString() << endl;
  out_stream.flush();

  out_stream << "COMPUTE MIN COST\n";
  int min_cost = traversal.DoTraversal();

  out_stream << "FINAL TREE\n" << traversal.ToString() << endl;
  out_stream.flush();

  out_stream << "MIN COST is " << min_cost << endl;
  out_stream.flush();

  Utils::FileClose(out_stream);

  Utils::log_stream << "Ending execution\n";
  Utils::log_stream.flush();

  Utils::FileClose(Utils::log_stream);

  return 0;
}
