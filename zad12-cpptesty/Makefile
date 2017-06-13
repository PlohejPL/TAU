

all: build/sortlib.o

build/sortlib.o: src/sortlib.cpp
	g++ -std=c++11 -c src/sortlib.cpp -o build/sortlib.o

tests: unit
	./unit -r junit
	./unit -s

unit: build/unit_sortlib.o build/units.o build/sortlib.o
	g++ build/unit_sortlib.o build/units.o build/sortlib.o -o unit


build/units.o: src/tests/units.cpp
	g++ -std=c++11 -Isrc -Ithirdparty -c src/tests/units.cpp -o build/units.o

build/unit_sortlib.o: src/tests/unit_sortlib.cpp
	g++ -std=c++11 -Isrc -Ithirdparty  -c src/tests/unit_sortlib.cpp -o build/unit_sortlib.o

clean:
	rm -f build/*.o unit

