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
int AccrueWealth(double goal, double investment, double rate);
double RateConversion(double rate);
/*
 *Main method prompts user for desired investment goal
 */
int main( ) {
  double goal_ = 0.0;
  double investment_ = 0.0;
  double rate_ = 0.0;
  int months_ = 0;
  cout << "Enter the desired goal for investment." << endl;
  cin >> goal_;
  cout << "Enter desired investment per month" << endl;
  cin >> investment_;
  cout << "Enter rate of return as a yearly percent." << endl;
  cin >> rate_;
  
  cout << "Goal:" << goal_ << endl;
  cout << "Monthly Investment:" << investment_ << endl;
  cout << "Rate of Return:" << rate_ << endl;
  
  //convert rate to the monthly total, and create copy of rate?
  
  months_ = AccrueWealth(goal_, investment_, rate_); 
  
  cout << "It will take " << months_ 
       << " months to achieve the desired investment goal of "
       << goal_ << " with a monthly investment of "
       << investment_ << " and a yearly return rate of "
       << rate_ << "%." << endl;
  return 0;
}

// int main( )

/****************************************************************
 * Function to compute accrued wealth.
 * Author: Duncan Buell
 * Used with permission and modified by: Julian Amrine
 * Date: 14 May 2016
 *
 * Function increments variable of the current investment by the calculated rate
 * adding the monthly investment 
**/
int AccrueWealth(double goal, double investment, double rate) {
  
  int months = 0;
  double investment_current_ = 0.0;
  double calc_rate = RateConversion(rate);  
  investment_current_ += investment;

  while(investment_current_<goal)
  {
    investment_current_ += ((investment_current_*(calc_rate))
                         + (investment));
    ++months;
    cout << months << endl;
  }
  
  return months;

} // LONG AccrueWealth(double goal, double investment, double rate)

double RateConversion(double rate)
{
  int percentile = 100;
  int months = 12;
  double new_rate = rate/percentile/months;
  cout << new_rate << endl;
  return new_rate;
}
