#include <iostream>
using namespace std;

class Count {
public:
    int counter = 0;
    void counterUp() {
        counter += 1;
    }
    void counterDown() {
        if (counter > 0) {
            counter -= 1;
        }
    }
};

int main() {
    int n, a;
    Count number;
    while (cin >> a) {
        if (a == 0) {
            cin >> n;
            number.counter = n;
        } else if (a == 1) {
            number.counterUp();
        } else if (a == -1) {
            number.counterDown();
        } else if (a == 9) {
            cout << number.counter << endl;
        } else if (a == -9) {
            break;
        }
    }
    return 0;
}

