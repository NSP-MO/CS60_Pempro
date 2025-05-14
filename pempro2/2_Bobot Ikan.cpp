#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class FishOrder {
private:
    vector<double> BobotIkan;
    double TargetWeight;

public:
    FishOrder(double TargetWeight) : TargetWeight(TargetWeight) {}

    void addFish(double weight) {
        BobotIkan.push_back(weight);
    }

    int FishCount() {
        sort(BobotIkan.begin(), BobotIkan.end(), greater<double>());

        double sum = 0.0;
        int count = 0;

        for (double weight : BobotIkan) {
            sum += weight;
            count++;
            if (sum >= TargetWeight) {
                return count;
            }
        }
        return -1;
    }
};

int main() {
    int N;
    double M;
    cin >> N >> M;
    FishOrder order(M);
    for (int i = 0; i < N; i++) {
        double weight;
        cin >> weight;
        order.addFish(weight);
    }
    cout << order.FishCount() << endl;
    return 0;
}

