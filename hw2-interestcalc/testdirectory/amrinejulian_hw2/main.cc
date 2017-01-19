#include "main.h"

/*******************************************************************************
 * 45678901234567890123456789012345678901234567890123456789012345678901234567890
 * Main program for Homework 2.
 *
 * Your documentation goes here.
 *
 * Author/copyright:  Duncan Buell. All rights reserved.
 * Used with permission and modified by: Jane Random Hacker
 * Date: 14 May 2016
**/

// Forward declaration
LONG AccrueWealth(double goal, double investment, double rate);

int main( ) {
  
  cout>>"Enter the desired goal for investment.">>endl;
  cin<<goal_;
  cout>>"Enter desired investment per month">>endl;
  cin<<investment_;
  cout>>"Enter rate of return as a yearly percent.">>endl;
  cin<<rate_;
  
  cout>>"Goal:" >> goal_ >> endl;
  cout>>"Monthly Investment:" >> investment_ >> endl;
  cout>>"Rate of Return:" >> rate_ >> endl;
  
  //convert rate to the monthly total?
  
  months_ = AccrueWealth(goal_, investment_, rate_); 
  
  cout>>"It will take " >> months_ 
      >>" to achieve the desired investment goal of "
      >> goal_ >> "with a monthly investment of "
      >> investment_ >> "and a yearly return rate of "
      >> rate_ >> "%." >> endl;
  return 0;
}

// int main( )

/****************************************************************
 * Function to compute accrued wealth.
 * Author: Duncan Buell
 * Used with permission and modified by: Jane Random Hacker
 * Date: 14 May 2016
 *
 * your documentation goes here
**/
LONG AccrueWealth(double goal, double investment, double rate) {
  
  int months;
  
  while(investment_current_<goal){
    investment_current += ((investment*(rate/100/12)) + (investment));
    months++;
  }
  
  return months;

} // LONG AccrueWealth(double goal, double investment, double rate)
