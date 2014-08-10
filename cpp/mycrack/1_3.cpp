#include <iostream>
#include <string>
using namespace std;

string removeDuplicate1(string s){
    int check = 0;
    int len = s.length();
    if (len < 2) return s;
    string str = "";
    for (int i = 0; i < len; ++i){
        int v = (int)(s[i]-'a');
        if ((check & (1 << v)) == 0){
            str += s[i];
            check |= (1 << v);
        }
    }
    return str;
}

int main(){
    return 0;
}

