#include <iostream>
using namespace std;

class Shape {
public:
int edge_length;
int circumference () {
//virtual int circumference () {
cout << "Base" << endl;
return 0;
}
};
class Triangle: public Shape {
public:
int circumference () {
cout << "Triangle" << endl;
return 3 * edge_length;
}
};
int main() {
Shape * x = new Shape();
x->circumference(); // prints “Circumference of Base Class”
Shape *y = new Triangle();
y->circumference(); // prints “Circumference of Triangle Class”
}
