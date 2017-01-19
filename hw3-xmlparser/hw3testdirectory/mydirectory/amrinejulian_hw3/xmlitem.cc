#include "xmlitem.h"

static const string kTag = "XMLITEM: ";

/**************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Homework 03.
 * Class for handling the XML data.
 * This class merely wraps a category label and a 'string'
 * object of the "contents" of the XML input.
 * Author/Copyright (C) 2015 by Duncan A. Buell.  All rights reserved.
 * Used with permission and modified by: Julian Amrine
 * Date: 22 June 2016
**/

/******************************************************************************
 * Constructor
 * Initializes item name to empty, and the state to null
 *   the_item_ -- a string representing either the tag or data
 *   state_ -- classifies the xml item
**/
XMLItem::XMLItem() {
  this->the_item_ = "Empty"
  this->state_ = null;
}

/**************************************************************
 * Constructor.
 *
 * Parameters:
 *   text - the text to be parsed
**/
XMLItem::XMLItem(string text) {
  this->the_item_ = text;
  this->state_ = SetState(text);
}

/******************************************************************************
 * Destructor
**/
XMLItem::~XMLItem() {
}

/******************************************************************************
 * Accessors and Mutators
**/

/******************************************************************************
 * General functions.
**/

/**************************************************************
 * Accessors.
**/
/**************************************************************
 * Accessor function to get 'theItem'.
**/
string XMLItem::GetItemText() {
  return this->the_item_;
}

string XMLItem::GetStateText() {
  string ret_string = state_;
  return state_;
}

item_type_ XMLItem::SetState(string text) {
  if (text.IsBadXml()) {
    cout << kTag << "Bad XML formatting" << endl;
    return null;
  } else if (text.IsCloseTag()) {
    return close;
  } else if (text.IsOpenTag()) {
    return open;
  } else if (text.IsData()) {
    return data;
  }

}


/**************************************************************
 * Accessor function -- do we we have bad XML?
**/
bool XMLItem::IsBadXml() {
  if ((this->the_item_.at(0) == < &&
       this->the_item_.at(1) != / &&
       this->the_item_.at(the_item_.size-1) != >) ||
      (this->the_item_.at(0) == < &&
       this->the_item_.at(1) = / &&
       this->the_item_.at(the_item_.size-1) != >) ||
      (this->the_item_.at(0) != < &&
       this->the_item_.at(1) != / &&
       this->the_item_.at(the_item_.size-1) != >)) {

    return true;

  }
}

/**************************************************************
 * Accessor function -- do we we have a close tag?
**/
bool XMLItem::IsCloseTag() {
  if (this->the_item_.at(0) == < &&
      this->the_item_.at(1) == / &&
      this->the_item_.at(the_item_.size-1) == >) {

    return true;

  }
}

/**************************************************************
 * Accessor function -- do we we have data?
**/
bool XMLItem::IsData() {
  if (this->the_item_.at(0) != < &&
      this->the_item_.at(1) != / &&
      this->the_item_.at(the_item_.size-1) != >) {

    return true;

  }
}

/**************************************************************
 * Accessor function -- do we we have an open tag?
**/
bool XMLItem::IsOpenTag() {
  if (this->the_item_.at(0) == < &&
      this->the_item_.at(1) != / &&
      this->the_item_.at(the_item_.size-1) == >) {

        return true;
      }
}

/**************************************************************
 * Mutators.
**/

/**************************************************************
 * General functions.
**/

/**************************************************************
 * Initializer for an XMLItem, given a line of input text.
**/
void XMLItem::Init(string text) {
#ifdef EBUG
  cout << kTag << "enter Init\n";
#endif
  this.XMLItem = XML(text);
#ifdef EBUG
  cout << kTag << "leave Init\n";
#endif
}


/******************************************************************************
 * Function 'ToString'.
 * This is the usual 'ToString' of the data in the class.
 *
 * Returns:
 *   a formatted 'string' version of the data.
**/
string XMLItem::ToString() const
{
  string ret_string = "";
#ifdef EBUG
  cout << kTag << "enter ToString\n";
#endif
  ret_string += the_item_;
#ifdef EBUG
  cout << kTag << "leave ToString\n";
#endif
  return ret_string;
} // string XMLItem::toString()
