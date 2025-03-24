#include <bits/stdc++.h>

using namespace std;

class persegi {
    private:
        int sisi;
    public:
        persegi(int s) : sisi(s) {}
        int hitungLuas() {
            return sisi * sisi;
        }
};

int main() {
    int a;
    cin >> a;
    persegi p(a);
    cout << p.hitungLuas() << endl;
    return 0;
}
