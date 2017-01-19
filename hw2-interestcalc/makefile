GPP = g++ -O3 -Wall -std=c++11

UTILS = ../../Utilities

A = main.o
#S = scanner.o
#SL = scanline.o
U = utils.o

A = main.o

Aprog: $(A) $(S) $(SL) $(U)
	$(GPP) -o Aprog $(A) $(S) $(SL) $(U)

main.o: main.h main.cc
	$(GPP) -c main.cc

#Scanner.o: $(UTILS)/Scanner.h $(UTILS)/Scanner.cc
	#$(GPP) -c $(UTILS)/Scanner.cc

#ScanLine.o: $(UTILS)/ScanLine.h $(UTILS)/ScanLine.cc
	#$(GPP) -c $(UTILS)/ScanLine.cc

utils.o: $(UTILS)/utils.h $(UTILS)/utils.cc
	$(GPP) -c $(UTILS)/utils.cc

