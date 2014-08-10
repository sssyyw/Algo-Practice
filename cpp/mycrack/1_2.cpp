#include <iostream>
#include <cstring>

using namespace std;

void swap(int &a, int &b){
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
}

void reverse2(char *s){
    int n = strlen(s);
    for (int i = 0; i < n / 2; ++i)
        swap(s[i], s[n-i-1]);
}

int main(){
    char s[] = "12345abcde";
    reverse2(s);
    cout << s << endl;
    return 0;
}
