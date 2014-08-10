#include <malloc.h>

int ** My2DAlloc(int rows, int cols){
	int header = rows * sizeof(int *);
        int data = rows * cols * sizeof(int);
        int** rowptr = (int**)malloc(header + data);
        int* buf = (int*)(rowptr+rows);
        int k;
	for (k = 0; k < rows; ++k){
		rowptr[k] = buf + k*cols;
        }
        return rowptr;
}
