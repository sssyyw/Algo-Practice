#include <iostream>
using namespace std;

unsigned short ConvertRGB888toRGB565 (unsigned int nSourceColor)
{
      unsigned int r,g,b;
        r = (nSourceColor & 0x001f0000) >> 5;
          g = (nSourceColor & 0x00003f00) >> 3;
            b = nSourceColor & 0x0000001f;
            cout << (r | g | b) << endl;
              return (short) (r | g | b);
}

int main()
{
unsigned short b = 0x11556677;
unsigned short a = ConvertRGB888toRGB565(b);
cout << a << endl;
}
