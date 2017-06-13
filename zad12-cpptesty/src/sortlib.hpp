#ifndef __SORTLIB_HPP__
#define __SORTLIB_HPP__

/*class Sort
{
public :
	string name;
	virtual void do_sort(int A[], int n)=0;
};*/

class HeapSort// : public Sort
{
public:
	HeapSort();
	void do_sort(int A[], int n);
private:
	void heapify(int *tab, int heap_size, int i);
	void build_max_heap(int *tab, int rozmiar);
	void heapsort(int *tab, int rozmiar);
};

class QuickSortR// : public Sort
{
public:
	QuickSortR();
	void do_sort(int A[], int n);
private:
	int partitionr(int tablica[], int p, int r);
	void quicksortr(int tablica[], int p, int r);
};

#endif // __SORTLIB_HPP__
