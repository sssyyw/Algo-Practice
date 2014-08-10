#include <iostream>
#include <cstring>
using namespace std;

typedef struct node {
    int data;
    node *next;
}node;

bool hash[100];
node* init(int a[], int n){
    node *head, *p;
    for (int i = 0; i < n; ++i){
        node *nd = new node();
        nd->data = a[i];
        if (i == 0){
            head = p = nd;
            continue;
        }
        p->next = nd;
        p = nd;
    }
    return head;
}

void removeduplicate(node *head){
    if (head == NULL) return;
    node *p = head, *q = head->next;
    hash[head->data] = true;
    while(q){
        if (hash[q->data]){
            node *t = q;
            p->next = q->next;
            q = p->next;
            delete t;
        } else {
            hash[q->data] = true;
            p = q; q = q->next;
        }
    }
}


}


int main(){
}
