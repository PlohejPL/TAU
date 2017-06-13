#ifndef __SORTLIB_HPP__
#define __SORTLIB_HPP__

class QuickSortR
{
public:
	QuickSortR();
	void do_sort(int A[], int n);
private:
	int partitionr(int tablica[], int p, int r);
	void quicksortr(int tablica[], int p, int r);
};

#endif // __SORTLIB_HPP__
