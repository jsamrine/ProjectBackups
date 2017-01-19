/****************************************************************
 * Homework 2 header file.
 *
 * Author/copyright:  Duncan Buell
 * Used with permission and modified by: Julian Amrine
 * Date: 13 May 2016
**/
#ifndef MAIN_H
#define MAIN_H

#include <iostream>

#include "../../Utilities/utils.h"

using namespace std;

class Main {
public:
  double investment_;
  double rate_;
  double goal_;
  int months_;
  double investment_current_;
private:
  int months_in_year_;
  
};

#endif // MAIN_H
