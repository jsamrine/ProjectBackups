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
 
  int AccrueWealth();
  double RateConversion();  
private:
  double investment_;
  double rate_;
  double goal_;
  LONG months_;
  double investment_current_;
  
};

#endif // MAIN_H
