#include <list>
#include <iostream>

using namespace std;

int main(){

    list<int> l1 = {10, 45, 6};
    list<int>::iterator it1 = l1.begin(), it2 = l1.end();
    l1.insert(it1, 532413);
    --it1;
    while (it1 != it2){
        cout << *it1++ << endl;
    }

}
