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
double RateConversion(double rate);
/*
 *Main method prompts user for desired investment goal
 */
int main( ) {

  double goal_ = 0.0;
  double investment_ = 0.0;
  double rate_ = 0.0;
  LONG months_ = 0;

  cout << "Enter the desired goal for investment." << endl;
  cin >> goal_;
  cout << "Enter desired investment per month" << endl;
  cin >> investment_;
  cout << "Enter rate of return as a yearly percent." << endl;
  cin >> rate_;

  cout << "Goal:" << setprecision(2) << fixed << goal_ << endl;
  cout << "Monthly Investment:" << investment_ << endl;
  cout << "Rate of Return:" << rate_ << endl;

  //months_ = AccrueWealth(goal_, investment_, rate_); 

  cout << "It will take " << months_
       << " months to achieve the desired investment goal of " << goal_
       << " with a monthly investment of " << investment_
       << " and a yearly return rate of " << rate_ << "%." << endl;

  return 0;
}

/****************************************************************
 * Function to compute accrued wealth.
 * Author: Duncan Buell
 * Used with permission and modified by: Julian Amrine
 * Date: 14 May 2016
 *

 * Function increments variable of the current investment by the calculated rate
 * adding the monthly investment
**/
LONG AccrueWealth(double goal, double investment, double rate) {

 // const int kno_months = 12;
  int months = 0;
  double investment_current = 0.0;
  double calc_rate = RateConversion(rate);

  investment_current += investment;

  while (investment_current<goal) {
    investment_current += ((investment_current*(calc_rate)) + investment);
    ++months;
    cout << months << endl;
  }
  cout << months << endl;
  return months;

}

double RateConversion(double rate) {
  //need to be constants?
  int percentile = 100;
  int months = 12;

  double new_rate = rate/percentile/months;

  return new_rate;

}
