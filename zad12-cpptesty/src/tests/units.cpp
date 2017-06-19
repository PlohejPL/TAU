#include <sortlib.hpp>
#define CATCH_CONFIG_MAIN
#include <catch.hpp>
#include <iostream>

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
    REQUIRE(2 == 1);
	std::cout << "==+++++++++++++++++++++++++++++++++++++++++++++++++++==" << std::endl;
}
