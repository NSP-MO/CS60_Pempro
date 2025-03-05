#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, K;
    cin >> N >> K;
    
    vector<double> tasks(N);
    for (int i = 0; i < N; i++){
        cin >> tasks[i];
    }
    
    sort(tasks.begin(), tasks.end(), greater<double>());
    
    double totalTime = 0.0;
    for (int i = 0; i < N; i += K){
        totalTime += tasks[i];
    }
    
    cout << fixed << setprecision(2) << totalTime << "\n";
    
    return 0;
}
