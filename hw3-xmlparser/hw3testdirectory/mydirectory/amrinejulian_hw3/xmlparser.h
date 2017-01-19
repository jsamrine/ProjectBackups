/****************************************************************
 * Homework 3 header file for the XMLParser application class.
 *
 * Author/copyright:  Duncan Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 15 May 2016
**/

#ifndef XMLPARSER_H
#define XMLPARSER_H

#include <iostream>
#include <set>
#include <stack>
#include <vector>
using namespace std;

#include "../../Utilities/utils.h"
#include "../../Utilities/scanner.h"
#include "../../Utilities/scanline.h"

#include "xmlitem.h"

class XMLParser {
public:
 XMLParser();
 virtual ~XMLParser();

 bool ParseXml();
 void ReadDtd(Scanner& in_stream);
 void ReadXml(Scanner& in_stream);
 string ToStringDtd() const;
 string ToStringInput() const;

private:
 set<string> the_dtd_;
 stack<XMLItem> the_xml_;
 vector<XMLItem> the_input_;
};

#endif
