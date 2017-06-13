#include <sortlib.hpp>

//#define CATCH_CONFIG_MAIN
#include <catch.hpp>


/*TEST_CASE("check adding","[MathLib][addValues]") {
    MathLib calculator;
    REQUIRE_THROWS(calculator.addValues(0,0));
    SECTION("adding 1 + 2") {
        REQUIRE(calculator.addValues(1,2) == 3);
    }
    SECTION("adding 1 + 2 and it should be greater than 0") {
        REQUIRE(calculator.addValues(1,2) > 0);
    }
}*/

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

/*SCENARIO("Sorting array with Heap Sort") {
    HeapSort hs;
    const int size = 4;
    int tab[size];
    tab[0]=3;
    tab[1]=2;
    tab[2]=1;
    tab[3]=0;
    GIVEN("We have an unordered array") {
        REQUIRE(&tab != NULL);
        WHEN("We sort the array") {
            REQUIRE_NOTHROW(hs.do_sort(tab, size));
            THEN("Array should be sorted") {
                REQUIRE(tab[0] < tab[1]);
                REQUIRE(tab[1] < tab[2]);
                REQUIRE(tab[2] < tab[3]);
            }
        }
    }
}*/
