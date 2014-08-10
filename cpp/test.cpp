#include <iostream>
#include <string>
using namespace std;

string length_encoding(const string& s)
{
        char c = ' ';
            int num = 0;
                string result;
                    string::const_iterator it = s.begin();
                        for(; it != s.end(); ++it)
                                {
                                            if(*it!=c)
                                                        {
                                                                        if(num!=0)
                                                                                        {
                                                                                                            stringstream ss;
                                                                                                                            ss << num;
                                                                                                                                            string num_s(ss.str());
                                                                                                                                                            result += num_s;
                                                                                                                                                                        }

                                                                                    c = *it;
                                                                                                result.push_back(c);

                                                                                                            num = 1;
                                                                                                                    }
                                                    else
                                                                {
                                                                                num++;
                                                                                        }       
                                                        }

                            stringstream ss;
                                ss << num;
                                    string num_s(ss.str()); 
                                        result += num_s;

                                            return result;
}
void funPrint()
{
        string str1 = "Nab";
            string str2 = "Zif";
                string str3 = str1 + str2;
                    for (int i = 0; i <= 100; i++)
                            {
                                         if (i % 15 == 0)
                                                          cout << str3 << endl;
                                                  else if (i % 3 == 0)
                                                                   cout << str1 << endl;
                                                           else if (i % 5 == 0)
                                                                            cout << str2 << endl;
                                                                    else 
                                                                                     cout << i << endl;
                                                                        }

}

int main(){
    //funPrint();
    length_encoding("fdafdfffff");
}
