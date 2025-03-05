#include <iostream>
class MyClass
{
private:
int a,b;
public:
MyClass(int p=0, int q=0) : a(p), b(q){}
void set(int p, int q) {a=p; b=q;}
void setA(int p) {a=p;}
void setB(int q) {b=q;}
int sum() { return a+b; }
};
int main()
{
MyClass myObj1(0,0); // a dan b bernilai 0
MyClass myObj2(5, 10); // a bernilai 5, b bernilai 10
MyClass myObj3(2000, 300);
std::cout << myObj1.sum() << std::endl;
myObj2.setB(8);
std::cout << myObj2.sum() << std::endl;
myObj3.setA(100);
std::cout << myObj3.sum() << std::endl;
return 0;
}