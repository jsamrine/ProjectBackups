/****************************************************************
 * Homework 3 header file for the XMLItem data payload class.
 *
 * Author/copyright:  Duncan Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 15 May 2016
**/

#ifndef XMLITEM_H
#define XMLITEM_H

#include <iostream>
using namespace std;

#include "../../Utilities/utils.h"
#include "../../Utilities/scanner.h"
#include "../../Utilities/scanline.h"

class XMLItem {
public:
 XMLItem();
 XMLItem(string text);

 virtual ~XMLItem();

 string GetItemText();
 void Init(string text);
 bool IsBadXml();
 bool IsCloseTag();
 bool IsData();
 bool IsOpenTag();
 item_type_ GetState(string text);
 string ToString() const;

private:
 enum item_type_ {open, close, data, null};
 item_type_ state_;
 string the_item_;
};

#endif
