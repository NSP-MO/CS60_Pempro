#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

int main() {
    int M;
    cin >> M;  // read the minimum threshold
    vector<double> scores;
    double value;
    
    // Read all scores until -1 is encountered
    while (cin >> value && value != -1) {
        // Only include scores that are >= M
        if (value >= M) {
            scores.push_back(value);
        }
    }
    
    // Check if there is at least one valid score
    if (scores.size() == 0) {
        cout << fixed << setprecision(2) << 0.00 << " " << 0.00 << endl;
        return 0;
    }
    
    // Compute the mean (rataan)
    double sum = 0;
    for (double x : scores) {
        sum += x;
    }
    double mean = sum / scores.size();
    
    // Compute the sample variance (ragam)
    // For a single data point, we'll assume the variance is 0.
    double variance = 0;
    if (scores.size() > 1) {
        double sumSquaredDiff = 0;
        for (double x : scores) {
            sumSquaredDiff += (x - mean) * (x - mean);
        }
        variance = sumSquaredDiff / (scores.size() - 1);
    }
    
    // Output the mean and variance with 2 decimal places
    cout << fixed << setprecision(2) << mean << " " << variance << endl;
    
    return 0;
}
