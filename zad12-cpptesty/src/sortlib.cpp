#include "sortlib.hpp"

#include <time.h>
#include <stdlib.h>


#ifndef poczatek
#define poczatek 0
#endif

void swap(int A[], int j, int i){

	int pom = A[j];
	A[j] = A[i];
	A[i] = pom;


}

QuickSortR::QuickSortR()
{
	
}

void QuickSortR::do_sort(int A[], int n)
{
	n--;
	quicksortr(A, poczatek, n);
}

int QuickSortR::partitionr(int tablica[], int p, int r)
{
	srand(time(NULL));
	int rand_number = rand() % (r - p + 1) + p;
	swap(tablica, rand_number, r);
	int x = tablica[r];
	int i = p - 1;
	int j;

	for (j = p; j <= r - 1; j++){
		if (tablica[j] <= x){
			i++;
			swap(tablica, j, i);
		}
	}
	swap(tablica, i + 1, r);
	return i + 1;
}

void QuickSortR::quicksortr(int tablica[], int p, int r)
{
	int q;
	if (p < r)
	{
		q = partitionr(tablica, p, r);
		quicksortr(tablica, p, q - 1);
		quicksortr(tablica, q + 1, r);
	}
}

