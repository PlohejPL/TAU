#include <sortlib.hpp>

#include <catch.hpp>



TEST_CASE("Tab sorts sorted array") {
    QuickSortR qs;
    const int size = 4;
    int tab[size];
    for(int i=0; i<size; i++){
	tab[i]=1;
    }
    REQUIRE(&tab != NULL);
    REQUIRE_NOTHROW(qs.do_sort(tab, size));
    REQUIRE(tab[0] <= tab[1]);
    REQUIRE(tab[1] <= tab[2]);
    REQUIRE(tab[2] <= tab[3]);
    //REQUIRE(2 == 1);//asda
}

SCENARIO("Sorting array with Quick Sort") {
    QuickSortR qs;
    const int size = 4;
    int tab[size];
    tab[0]=3;
    tab[1]=2;
    tab[2]=1;
    tab[3]=0;
    GIVEN("We have an unordered array") {
        REQUIRE(&tab != NULL);
        WHEN("We sort the array") {
            REQUIRE_NOTHROW(qs.do_sort(tab, size));
            THEN("Array should be sorted") {
                REQUIRE(tab[0] < tab[1]);
                REQUIRE(tab[1] < tab[2]);
                REQUIRE(tab[2] < tab[3]);
            }
        }
    }
}

SCENARIO("Sorting big array with Quick Sort") {
    QuickSortR qs;
    const int size = 10;
    int tab[size];
    for(int i=0; i<size; i++){
		tab[i]=size - i;
	}
    GIVEN("We have an unordered array") {
        REQUIRE(&tab != NULL);
        WHEN("We sort the array") {
            REQUIRE_NOTHROW(qs.do_sort(tab, size));
            THEN("Array should be sorted") {
				for(int i=0; i<size-1; i++){
					REQUIRE(tab[i] < tab[i+1]);
				}
            }
        }
    }
}


