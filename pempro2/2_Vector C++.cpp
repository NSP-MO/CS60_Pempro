#include <vector>
#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    vector<double> v;
    double sum = 0;
    double mean = 0, variance = 0;
    double temp;
    int n;
    cin >> n;
    while (cin >> temp && temp != -1) {
        if (temp >= n) {
            v.push_back(temp);
            sum += temp;
        }
    }
    mean = sum / v.size();

    double sigma_diff = 0.0;

    for (int num : v) {
        double diff = num - mean;
        sigma_diff += diff * diff;
    }

    if (v.size() > 1) {
        variance = sigma_diff / (v.size() - 1);
    } else {
        variance = 0.0;
    }

    if (v.empty()) {
        cout << "0.00 0.00" << endl;
        return 0;
    }

    cout << fixed << setprecision(2) << mean << " " << variance << endl;

}


