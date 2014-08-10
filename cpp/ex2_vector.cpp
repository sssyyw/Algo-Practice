#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
    string str;
    vector<string> bag;

    string s("fdsafdfa");
    cout << s.substr(0,5) << endl;
    if (s.begin() != s.end()){
        string::iterator it = s.begin();
        cout << *it << endl;
    }

    vector<int> v{1, 2, 3, 4, 5, 6, 7, 8};
    for (int &i : v)
        i *= i;
    for (auto i : v)
        cout << i << endl;

    while (cin >> str)
        if (str == " ")
            break;
        else 
            bag.push_back(str);

    for (auto tmp: bag)
        cout << tmp << endl;

    return 0;
}
