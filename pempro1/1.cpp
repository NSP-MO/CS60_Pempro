#include <iostream>
#include <iomanip>
#include <vector>
using namespace std;

class Mean {
    private:
        vector<int> numbers;

    public:
        void addNumber(int number) {
            numbers.push_back(number);
        }

        double mean() {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return static_cast<double>(sum) / numbers.size();
        }
};

int main() {
    Mean mean;
    for (int i = 0; i < 4; i++) {
        int number;
        cin >> number;
        mean.addNumber(number);
    }
    cout << fixed << setprecision(2) << mean.mean() << endl;
    return 0;
}


