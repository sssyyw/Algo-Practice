#include <iostream>
using namespace std;

void toy(int &a, int &b){
    a = a^b;
    b = a^b;
    a = a^b;
}

int main(){
    int x = 6;
    int y = 19;
    toy(x, y);
    cout << "x is " << x << endl;
    cout << "y is " << y << endl;

}
