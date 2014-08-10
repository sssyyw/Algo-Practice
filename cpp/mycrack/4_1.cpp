#include <iostream>
#include <cstirng>
#include <cmath>

using namespace std;

const int maxn = 100;

struct Node{
    int key;
    Node *lchild, *rchild, *parent;
};

Node *head, *p, node[maxn];
