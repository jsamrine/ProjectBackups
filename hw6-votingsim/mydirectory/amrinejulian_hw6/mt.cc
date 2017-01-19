// mersenne_twister_engine constructor
#include <iostream>
#include <chrono>
#include <random>

int main ()
{
  // obtain a seed from the system clock:
  unsigned seed1 = std::chrono::system_clock::now().time_since_epoch().count();

  // obtain a seed from the user:
  std::string str;
//  std::cout << "Please, enter a seed: ";
//  std::getline(std::cin,str);
//  std::seed_seq seed2 (str.begin(),str.end());

//  std::mt19937 g1 (seed1);  // mt19937 is a standard mersenne_twister_engine
//  std::cout << "A time seed produced: " << g1() << std::endl;

//  std::mt19937 g2 (seed2);
//  std::cout << "Your seed produced: " << g2() << std::endl;

  unsigned seed3 = 10;
  std::mt19937 g3 (seed3);
  std::cout << "Coded seed 1 produced: " << g3() << std::endl;

  unsigned seed4 = 20;
  std::mt19937 g4 (seed4);
  std::cout << "Coded seed 2 produced: " << g4() << std::endl;
  for (int i = 0; i < 10; ++i)
  {
    std::cout << "Coded seed 2 produced: " << g4() << std::endl;
  }

  return 0;
}
