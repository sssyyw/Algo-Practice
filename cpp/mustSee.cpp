#include <iostream>
using namespace std;

void shit(int *p){
    cout << p[1] << endl;
}

int main(){
    int a = 5;
    shit(&a);
    return 0;
}
