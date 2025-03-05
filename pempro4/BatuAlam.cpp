#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

class Persegi {
private:
    int panjang;
    int lebar;
public:
    Persegi(int p, int l) : panjang(p), lebar(l) {}
    int hitungLuas() {
        return panjang * lebar;
    }
};

int main() {
    int N, K;
    cin >> N >> K;
    
    vector<Persegi> stones;
    for (int i = 0; i < N; ++i) {
        int p, l;
        cin >> p >> l;
        stones.emplace_back(p, l);
    }
    
    vector<int> areas;
    for (auto& stone : stones) {
        areas.push_back(stone.hitungLuas());
    }
    
    sort(areas.begin(), areas.end());
    
    for (int i = 0; i < K; ++i) {
        cout << areas[i] << endl;
    }
    
    return 0;
}