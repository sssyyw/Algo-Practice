#include <iostream>
using namespace std;

const int MAX_INT = ~(1 << 31);

typedef struct node{
    int val min;
}node;

class StackWithMin1{
public:
    StackWithMin1(){
    }
    ~StackWithMin1(){
    }

    void push(int val){
        s1.push(val);
        if (val <= min())
            s2.push(val);
    }

    void pop(){
        if (s1.top() == min())
            s2.pop();
        s1.pop();
    }

    int top(){
        return s1.top();
    }

    int min(){
        if(s2.empty()) return MAX_INT;
        else return s2.top();
    }

private:
    stack s1, s2;
};


