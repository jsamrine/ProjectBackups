#include "main.h"

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Homework 3 main program.
 *
 * This program reads a DTD and creates a 'set' of legal XML tags
 * and then reads and parses an XML file to determine if the file is
 * written as properly nested XML.
 *
 * Author: Duncan A. Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 15 May 2016
**/

int main(int argc, char *argv[]) {
  bool parse_was_good = false;
  string data_filename = "";
  string dtd_filename = "";
  string out_filename = "";
  ofstream out_stream;

  Scanner in_stream;

  XMLParser xml_parser;

  Utils::CheckArgs(3, argc, argv, "dtdfilename datafilename outfilename");
  dtd_filename = static_cast<string>(argv[1]);
  data_filename = static_cast<string>(argv[2]);
  out_filename = static_cast<string>(argv[3]);

  cout << "Beginning execution\n";

  Utils::FileOpen(out_stream, out_filename);

  cout << "dtdfile  '" << dtd_filename << "'\n";
  cout << "datafile  '" << data_filename << "'\n";
  cout << "outfile '" << out_filename << "'\n";

  in_stream.OpenFile(dtd_filename);
  xml_parser.ReadDtd(in_stream);
  in_stream.Close();

  out_stream << "DTD\n" << xml_parser.ToStringDtd() << endl;
  out_stream.flush();

  in_stream.OpenFile(data_filename);
  xml_parser.ReadXml(in_stream);
  in_stream.Close();

  out_stream << "input to be tested\n" << xml_parser.ToStringInput() << endl;
  out_stream.flush();

  parse_was_good = xml_parser.ParseXml();
  if (parse_was_good) {
    out_stream << "XML is correctly formatted\n" << endl;
  } else {
    out_stream << "XML is NOT correctly formatted\n" << endl;
  }
  out_stream.flush();

  Utils::FileClose(out_stream);

  cout << "Ending execution\n";

  return 0;

}
