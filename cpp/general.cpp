#include <iostream>
using namespace std;

int main(){
    int a = 1;
    int b = 10;
    int c = 100;
    int d = 1000;
    int * const p = &a;
    (*p)++;
    int *p2 = p;
    const int &r = b;
    string str = "shit";
//    r++;
//    int &r2 = r;
//    r = a;
    cout << str << "--" << b << "--" << r << endl;
//    int *p1 = nullptr;
    string line;
    while (getline(cin, line))
        if (!line.empty())
                cout << line << endl;
}
