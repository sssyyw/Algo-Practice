#include <iostream>
using namespace std;

typedef struct node{
    int data;
    node *next;
}node;

bool remove(node *c){
    if (c == NULL || c->next == NULL) return false;
    node *q = c->next;
    c->data = q->data;
    c->next = q->next;
    delete q;
    return true;

}
