GPP = g++ -O3 -Wall -std=c++11

UTILS = ../../Utilities

A = main.o
X = xmlparser.o
I = xmlitem.o
S = scanner.o
SL = scanline.o
U = utils.o

Aprog: $(A) $(X) $(I) $(S) $(SL) $(U)
	$(GPP) -o Aprog $(A) $(X) $(I) $(S) $(SL) $(U)

main.o: main.h main.cc
	$(GPP) -c main.cc

xmlparser.o: xmlparser.h xmlparser.cc
#	$(GPP) -c -DEBUG xmlparser.cc
	$(GPP) -c xmlparser.cc

xmlitem.o: xmlitem.h xmlitem.cc
#	$(GPP) -c -DEBUG xmlitem.cc
	$(GPP) -c xmlitem.cc

scanner.o: $(UTILS)/scanner.h $(UTILS)/scanner.cc
	$(GPP) -c $(UTILS)/scanner.cc

scanline.o: $(UTILS)/scanline.h $(UTILS)/scanline.cc
	$(GPP) -c $(UTILS)/scanline.cc

utils.o: $(UTILS)/utils.h $(UTILS)/utils.cc
	$(GPP) -c $(UTILS)/utils.cc

