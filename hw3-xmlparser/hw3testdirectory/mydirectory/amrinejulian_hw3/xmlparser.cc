#include "xmlparser.h"

static const string kTag = "XMLPARSER: ";

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Homework 3 'XMLParser' application class.
 *
 * Author: Duncan A. Buell
 * Used with permission and modified by: Julian Amrine
 * Date: 15 May 2016
**/

/******************************************************************************
 * Constructor
**/
XMLParser::XMLParser() {
}

/******************************************************************************
 * Destructor
**/
XMLParser::~XMLParser() {
}

/******************************************************************************
 * Accessors and Mutators
**/

/******************************************************************************
 * General functions.
**/

/******************************************************************************
 * Function 'ParseXml'.
**/
bool XMLParser::ParseXml()
{
  bool good_parse = false;
#ifdef EBUG
  cout << kTag << "enter ParseXml\n";
#endif
 //read element from xml vector
 //if open in dtd, push else error 0;
 //if data push
 //if close pop,
   //if popped data is data continue to pop
   //if popped open is the same as closing, continue
   //if not, return error 1
   //if execution complete and stack is empty, return error 2
   //
#ifdef EBUG
  cout << kTag << "leave ParseXml\n";
#endif

  return good_parse;
} // void XMLParser::ParseXml()

/******************************************************************************
 * Function 'ReadDtd'.
**/
void XMLParser::ReadDtd(Scanner& in_stream)
{
#ifdef EBUG
  cout << kTag << "enter ReadDtd\n";
#endif
  //while the scanner has more items
  //add each item to the dtd set
  string dtd_item
  while (in_stream.HasNext()) {
    dtd_item = in_stream.Next();
    the_dtd_.insert(dtd_item)
  }


#ifdef EBUG
  cout << kTag << "leave ReadDtd\n";
#endif
} // bool XMLParser::ReadDtd(Scanner& in_stream)

/******************************************************************************
 * Function 'ReadXml'.
**/
void XMLParser::ReadXml(Scanner& in_stream)
{
  string raw_line = "";
  XMLItem new_item;
#ifdef EBUG
  cout << kTag << "enter ReadXml\n";
#endif
  while (in_stream.HasNext()) {
    raw_line = in_stream.Next();
    new_item.Init(raw_line)
    the_input_.pushback(new_item);
  }
#ifdef EBUG
  cout << kTag << "leave ReadXml\n";
#endif
} // void XMLParser::ReadXml(Scanner& in_stream)

/******************************************************************************
 * Function 'ToStringDtd'.
 * This is the usual 'ToString' of a 'set' that is the DTD.
 *
 * Returns:
 *   a formatted 'string' version of the 'set' of legal XML tags in the DTD.
**/
string XMLParser::ToStringDtd() const {
  string ret_value = "";
#ifdef EBUG
  cout << kTag << "enter ToStringDtd\n";
#endif
  set<string>::const_iterator iter;
  for(iter = the_data_.begin(); iter != the_data_.end(); ++iter)
  {
    s += (*iter) + "\n";
  }
#ifdef EBUG
  cout << kTag << "leave ToStringDtd\n";
#endif
  return s;
} // string XMLParser::ToStringDtd()

/******************************************************************************
 * Function 'ToStringInput'.
 * This is the usual 'ToString' of a 'vector' that is the input.
 *
 * Returns:
 *   a formatted 'string' version of the XML in the input.
**/
string XMLParser::ToStringInput() const
{
  string s = "";
#ifdef EBUG
  cout << kTag << "enter ToStringInput\n";
#endif
  for(int i = 0; i<the_input_.size()-1; i++)
  {
    s += the_input_.at(0) + "\n";
  }
#ifdef EBUG
  cout << kTag << "leave ToStringInput\n";
#endif
  return s;
} // string XMLParser::ToStringInput()
