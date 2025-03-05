#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

long gcd(long a, long b) {
    a = labs(a);
    b = labs(b);
    while(b != 0) {
        long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

class abc {
private:
    long num, var2;
    void simplify() {
        if (var2 < 0) {
            num = -num;
            var2 = -var2;
        }
        long g = gcd(num, var2);
        if (g != 0) {
            num /= g;
            var2 /= g;
        }
    }
    
public:
    abc(): num(0), var2(1) { }
    
    void set(long a, long b, long c) {
        num = a * c + b;
        var2 = c;
        simplify();
    }
    
    void add(long a, long b, long c) {
        long n2 = a * c + b;  
        long d2 = c;
        num = num * d2 + n2 * var2;
        var2 = var2 * d2;
        simplify();
    }
    
    void mul(long a, long b, long c) {
        long n2 = a * c + b;
        long d2 = c;
        num = num * n2;
        var2 = var2 * d2;
        simplify();
    }
    
    void inc() {
        num += var2;
        simplify();
    }
    
    void dec() {
        num -= var2;
        simplify();
    }
    
    void p() {
        simplify();
        if(num % var2 == 0) {
            cout << num/var2 << "\n";
        } else if(labs(num) > var2) {
            long n = num / var2;
            long sisa = labs(num % var2);
            cout << n << " " << sisa << "/" << var2 << "\n";
        } else {
            cout << num << "/" << var2 << "\n";
        }
    }
};

int main(){
    abc abc;
    string prompt;
    
    while(cin >> prompt) {
        if(prompt == "set") {
            long a, b, c;
            cin >> a >> b >> c;
            abc.set(a, b, c);
        }
        else if(prompt == "p") {
            abc.p();
        }
        else if(prompt == "add") {
            long a, b, c;
            cin >> a >> b >> c;
            abc.add(a, b, c);
        }
        else if(prompt == "mul") {
            long a, b, c;
            cin >> a >> b >> c;
            abc.mul(a, b, c);
        }
        else if(prompt == "inc") {
            abc.inc();
        }
        else if(prompt == "dec") {
            abc.dec();
        }
        else if(prompt == "end") {
            break;
        }
    }
    return 0;
}
