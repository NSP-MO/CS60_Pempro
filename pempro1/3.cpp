#include <iostream>
using namespace std;

class abc {
private:
    int num, gen;
    void simplify() {
        int common = gcd(num, den);
        num /= common;
        den /= common;
        if (den < 0) {
            num *= -1;
            den *= -1;
        }
    }
public:
    abc() : num(0), den(1) {
        
    }
    void p() {
        
    }       
    }
};

long gcd(long a, int b) {
    a = abs(a);
    b = abs(b);
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
};

int main() {
    abc abcd;
    char keyword;

    cin >> keyword;
    if (keyword == 'set') {
}