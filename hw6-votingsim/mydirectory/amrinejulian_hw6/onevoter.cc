#include "onevoter.h"

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Class 'OneVoter' for the queueing theory computation.
 *
 * Author: Duncan A. Buell
 * Modified and used with permission by Julian Amrine
 * Date last modified: 11 July 2016
**/

/******************************************************************************
 * Constructor
**/
OneVoter::OneVoter() : sequence_number_(kDummySequenceNumber),
                       time_arrival_(kDummyTimeArrival),
                       time_start_voting_(kDummyTimeStart),
                       time_vote_duration_(kDummyTimeDuration),
                       machine_number_(kDummyMachineNumber),
                       time_done_voting_(kDummyTimeDone),
                       time_waiting_(kDummyTimeWaiting) {
// empty by design
}

/******************************************************************************
 * Constructor
**/
OneVoter::OneVoter(int sequence, int arrival, int duration) {
  Init(int sequence, int arrival, int duration);

}
/*
 * Initializer
 */
void OneVoter::Init(int sequence, int arrival, int duration) {
  sequence_number_(sequence);
  time_arrival_(arrival);
  time_vote_duration_(duration);
}

/******************************************************************************
 * Destructor
**/
OneVoter::~OneVoter() {
}

/******************************************************************************
 * Accessors and Mutators
**/

/******************************************************************************
 * Accessor for 'machine_number_'
**/
int OneVoter::GetMachineNumber() {
  return machine_number_;
}

/******************************************************************************
 * Accessor for 'sequence_number_'
**/
int OneVoter::GetSequenceNumber() {
  return sequence_number_;
}

/******************************************************************************
 * Accessor for 'time_arrival_'
**/
int OneVoter::GetTimeArrival() {
  return time_arrival_;
}

/******************************************************************************
 * Accessor for 'time_done_voting_'
**/
int OneVoter::GetTimeDoneVoting() {
  return time_done_voting_;
}

/******************************************************************************
 * Accessor for 'time_waiting_'
**/
int OneVoter::GetTimeWaiting() {
  return time_waiting_;
}

/*
 * Mutator for time_waiting_
 */
void OneVoter::SetTimeWaiting(int time_waiting) {
  time_waiting_(time_waiting);
}


/******************************************************************************
 * General functions.
**/

/******************************************************************************
 * Function 'AssignMachine' to assign this voter to a machine.
**/
void OneVoter::AssignMachine(int machine_number, int start_time) {
  machine_number_(machine_number);
  time_start_voting_(start_time);
}

/******************************************************************************
 * Function 'DoneVoting' to close out the record for this voter.
**/
void OneVoter::DoneVoting() {
  time_done_voting_ = time_start_voting_ + time_vote_duration_;
}

/******************************************************************************
 * Function 'ToString'.
**/
string OneVoter::ToString() const {
  string s = "";

  return s;
}
