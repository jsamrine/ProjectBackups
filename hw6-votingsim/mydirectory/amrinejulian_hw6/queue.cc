#include "queue.h"

static const string kTag = "QUEUE: ";

/******************************************************************************
 *3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
 * Class 'Queue' for the queueing theory computation.
 *
 * Author: Duncan A. Buell
 * Modified and used with permission by Julian Amrine
 * Date last modified: 11 July 2016
**/

/******************************************************************************
 * Constructor
**/
Queue::Queue() {
}

/******************************************************************************
 * Destructor
**/
Queue::~Queue() {
}

/******************************************************************************
 * Accessors and Mutators
**/
/******************************************************************************
 * Accessor for 'how_many_machines_lower_bound_'
**/
int Queue::GetHowManyMachinesLowerBound() {
  return how_many_machines_lower_bound_;
}

/******************************************************************************
 * Accessor for 'how_many_machines_upper_bound_'
**/
int Queue::GetHowManyMachinesUpperBound() {
  return how_many_machines_upper_bound_;
}

/******************************************************************************
 * Accessor for 'how_many_voters_'
**/
int Queue::GetHowManyVoters() {
  return how_many_voters_;
}

/******************************************************************************
 * Accessor for 'number_of_time_steps_'
**/
int Queue::GetNumberOfTimeSteps() {
  return number_of_time_steps_;
}

/******************************************************************************
 * Accessor for 'random_number_seed_'
**/
int Queue::GetRandomNumberSeed() {
  return random_number_seed_;
}

/******************************************************************************
 * Accessor for 'vote_time_dev_'
**/
int Queue::GetVoteTimeDev() {
  return vote_time_dev_;
}

/******************************************************************************
 * Accessor for 'vote_time_mean_'
**/
int Queue::GetVoteTimeMean() {
  return vote_time_mean_;
}

/******************************************************************************
 * General functions.
**/
/******************************************************************************
 * Function 'ComputeMeanAndDev'.
 * This computes the mean and standard deviation of the 'voters_done_voting'
 * wait times.
 *
 * We compute the mean as mean = sum(wait_time) / number_of_voters
 * and then we compute the deviation as
 *   dev = sqrt(sum(wait_time - mean) / number_of_voters)
 *
 * These values are returned as pass-by-reference parameters of the function.
 *
 * Parameters:
 *   mean - the mean
 *   dev - the standard deviation
**/
void Queue::ComputeMeanAndDev(double& mean, double& dev) {
  int sum_of_wait_times = 0;
  double sum_of_adjusted_times = 0.0;
  Utils::log_stream << kTag << "enter ComputeMeanAndDev" << endl;

  sum_of_wait_times = 0;
  multimap<int, OneVoter>::iterator iter_multimap;
  for (iter_multimap = voters_done_voting_.begin();
       iter_multimap != voters_done_voting_.end(); ++iter_multimap) {
    OneVoter voter = iter_multimap->second;
    sum_of_wait_times += voter.GetTimeWaiting();
  }
  mean = static_cast<double>(sum_of_wait_times)/
                   static_cast<double>(this->how_many_voters_);

  sum_of_adjusted_times = 0.0;
  for (iter_multimap = voters_done_voting_.begin();
       iter_multimap != voters_done_voting_.end(); ++iter_multimap) {
    OneVoter voter = iter_multimap->second;
    double this_addin = static_cast<double>(voter.GetTimeWaiting()) - mean;

    sum_of_adjusted_times += (this_addin) * (this_addin);
  }
  dev = sqrt(sum_of_adjusted_times/static_cast<double>(how_many_voters_));

  Utils::log_stream << kTag << "leave ComputeMeanAndDev" << endl;
}

/******************************************************************************
 * Function 'DoStatistics'.
 * This does stats on the voter queue 'voters_done_voting_'.
 *
 * We plot a histogram of the wait times and we compute the mean and deviation
 * of the wait times from that voter queue.
 *
 * Note that we use the square brackets for the wait time map because
 * we are pretty much guaranteed there are holes in the times when no data
 * will be present.
**/
void Queue::DoStatistics(int machine_count, ofstream& out_stream) {
  double mean = 0.0;
  double dev = 0.0;
  map<int, int> wait_time_map;

  Utils::log_stream << kTag << "enter DoStatistics" << endl;

  // Provide the configuration data.
  out_stream << kTag << "Random number seed: "
                     << this->GetRandomNumberSeed() << endl;
  out_stream << kTag << "# Voters: " << this->GetHowManyVoters() << endl;
  out_stream << kTag << "# Time steps: "
                     << this->GetNumberOfTimeSteps() << endl;
  out_stream << kTag << "# Machines: " << machine_count << endl;
  out_stream << kTag << "Mean & dev vote times: "
                     << this->GetVoteTimeMean() << " "
                     << this->GetVoteTimeDev() << endl << endl;
  out_stream.flush();

  // Compute the histogram.
  multimap<int, OneVoter>::iterator iter_multimap;
  for (iter_multimap = this->voters_done_voting_.begin();
       iter_multimap != this->voters_done_voting_.end(); ++iter_multimap) {
    OneVoter voter = iter_multimap->second;
    int wait_time = voter.GetTimeWaiting();
    wait_time_map[wait_time] = wait_time_map[wait_time] + 1;
  }

  // And plot the histogram.
  int time_lower = (wait_time_map.begin())->first;
  int time_upper = (wait_time_map.rbegin())->first;
  for (int time = time_lower; time <= time_upper; ++time) {
    int count = wait_time_map[time];
    out_stream << kTag << Utils::Format(time, 6) << ": "
                       << Utils::Format(count, 6) << ": ";
    out_stream << string(count, '*') << endl;
    out_stream.flush();
  }
  out_stream << kTag << endl << endl;
  out_stream.flush();

  ComputeMeanAndDev(mean, dev);
  out_stream << kTag << "mean and deviation of wait time are "
                     << mean << ", " << dev << endl;
  out_stream.flush();

  wait_time_map.clear();

  Utils::log_stream << kTag << "leave DoStatistics" << endl;
}

/******************************************************************************
 * Function 'ReadInputData'.
 * This reads the input data that configures the simulation.
 * Function collects:
 *                    integer value for the RNG seed
 *                    integer value for the number of voters
 *                    integer value for the lower bound of the
 *                      number of machines
 *                    integer value for the upper bound of the
 *                      number of machines
 *                    integer value for the number of time steps
 *                    integer values for mean and deviation of voting times
**/
void Queue::ReadInputData(Scanner& in_stream) {
  Utils::log_stream << kTag << "enter ReadInputData" << endl;

  if (in_stream.HasNext()) {
    random_number_seed_ = in_stream.NextInt();
  } else {
    cout << "No data for random_number_seed_ present" << endl;
    exit(0);
  }

  if (in_stream.HasNext()) {
    how_many_voters_ = in_stream.NextInt();
  } else {
    cout << "No data for how_many_voters_ present" << endl;
    exit(0);
  }

  if (in_stream.HasNext()) {
    how_many_machines_lower_bound_ = in_stream.NextInt();
  } else {
    cout << "No data for how_many_machines_lower_bound_ present" << endl;
    exit(0);
  }

  if (in_stream.HasNext()) {
    how_many_machines_upper_bound_ = in_stream.NextInt();
  } else {
    cout << "No data for how_many_machines_upper_bound_ present" << endl;
    exit(0);
  }

  if (in_stream.HastNext()) {
    number_of_time_steps_ = in_stream.NextInt();
  } else {
    cout << "No data for number_of_time_steps_ present" << endl;
    exit(0);
  }

  if(in_stream.HasNext()) {
    vote_time_mean_ = in_stream.NextInt();
  } else {
    cout << "No data for vote_time_mean_ present" << endl;
    exit(0);
  }

  if(in_stream.HasNext()) {
    vote_time_dev_ = in_stream.NextInt();
  } else {
    cout << "No data for vote_time_dev_ present" << endl;
    exit(0);
  }
  Utils::log_stream << kTag << "leave ReadInputData" << endl;
}

/******************************************************************************
 * Function 'InitializeVoters'.
**/
void Queue::InitializeVoters() {
  Utils::log_stream << "enter InitializeVoters" << endl;
  random_(random_number_seed_);
  int time_arrival;
  int time_vote_duration;
  for (int i = 1; i <= how_many_voters_; ++i) {
    time_arrival = random_.RandomNormal(GetVoteTimeMean(), GetVoteTimeDev());
    time_vote_duration = random_.RandomUniformInt(0, GetNumberOfTimeSteps());
    OneVoter a_voter(i, time_arrival, time_vote_duration);
    voters_pending[time_arrival] = a_voter;
  }
  cout << ToStringMultimap("Pending", voters_pending) << endl;
  Utils::log_stream << "leave InitializeVoters" << endl;
}

/******************************************************************************
 * Function 'RunSimulation'.
**/
void Queue::RunSimulation(ofstream& out_stream) {
  Utils::log_stream << kTag << "enter RunSimulation" << endl;
}

/******************************************************************************
 * Function 'RunSimulation2'.
**/
void Queue::RunSimulation2(int how_many_machines) {

  Utils::log_stream << kTag << "enter RunSimulation2 for machine count: "
                    << Utils::Format(how_many_machines, 5) << endl;

  Utils::log_stream << kTag << "leave RunSimulation2" << endl;
}

/******************************************************************************
 * Function 'ToString'.
**/
string Queue::ToString() const {
  string s = "";
  return s;
}
/******************************************************************************
 * Function 'ToStringMultimap'.
**/
string Queue::ToStringMultimap(string label,
                               const multimap<int, OneVoter> the_map) const {

  s += label + "\n";
  return s;
}
