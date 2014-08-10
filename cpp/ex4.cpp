#include <iostream>
#include <string>
#include <map>

using std::map;
using std::string;

int main(){
    int i = 42;
    string s = std::to_string(i);
    double d = std::stod(s);
    std::cout << d << std::endl;

    map<string, int> word_count;
    string word;
    while (std::cin >> word)
        ++word_count[word];
    for (const auto w : word_count)
        std::cout << w.first << " occurs " << w.second << std::endl;
    return 0;
}
