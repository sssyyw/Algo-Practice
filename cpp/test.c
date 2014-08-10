#include <stdio.h>

void func1(int *a, int N)
{
    int i = 0;
    for (i = 0; i < N; i++)
    {
        printf("%d", a[i]);
        printf("\n");
    }
}

int main()
{
    int d[] = {2, 3, 4, 5, 6};
    func1(d, 5);
}

