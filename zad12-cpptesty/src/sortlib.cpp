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

HeapSort::HeapSort()
{
	//name = "heap sort";
}
void HeapSort::do_sort(int A[], int n)
{
	n--;
	heapsort(A, n);
}
void HeapSort::heapify(int *tab, int heap_size, int i)
{
	int largest, temp;
	int l = (2 * i) + 1, r = (2 * i) + 2;
	if (l <= heap_size && tab[l]>tab[i])
		largest = l;
	else largest = i;
	if (r <= heap_size && tab[r]>tab[largest])
		largest = r;
	if (largest != i)
	{
		temp = tab[largest];
		tab[largest] = tab[i];
		tab[i] = temp;
		heapify(tab, heap_size, largest);
	}
}
void HeapSort::build_max_heap(int *tab, int rozmiar)
{
	for (int i = rozmiar / 2; i > 0; i--)
		heapify(tab, rozmiar, i);
}

void HeapSort::heapsort(int *tab, int rozmiar)
{
	int temp;
	build_max_heap(tab, rozmiar);
	for (int i = rozmiar; i >= 2; i--)
	{
		temp = tab[i];
		tab[i] = tab[poczatek];
		tab[poczatek] = temp;
		rozmiar--;
		heapify(tab, rozmiar, poczatek);
	}
	temp = tab[1];
}

QuickSortR::QuickSortR()
{
	//name = "quick sort R";
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

