#include <bits/stdc++.h>
using namespace std;

class Mhs {
    private:
        string nim;
        int sks;
        float ipk;
    public:
        Mhs(string nim, int sks, float ipk) {
            this->nim = nim;
            this->sks = sks;
            this->ipk = ipk;
        }
        string get_nim() {
            return nim;
        }
        int get_sks() {
            return sks;
        }
        float get_ipk() {
            return ipk;
        }
};

int main() {
    int n, k;
    cin >> n >> k;
    vector<Mhs> mhs;
    for (int i = 0; i < n; i++) {
        string nim;
        int s;
        int count = 0;
        float ipk=0.0;
        cin >> nim >> s;
        
        for (int j = 0; j < s; j++) {
            int sks;
            string mutu;
            float ipkTemp = 0.0;
            cin >> sks >> mutu;

            if (mutu == "A") ipkTemp = 4.0;
            else if (mutu == "B") ipkTemp = 3.0;
            else if (mutu == "C") ipkTemp = 2.0;
            else if (mutu == "D") ipkTemp = 1.0;
            else ipk = 0.0;

            count += sks;
            ipkTemp*=sks;
            ipk+=ipkTemp;   
        }
        ipk/=count;
        mhs.push_back(Mhs(nim, count, ipk));
    }

    sort(mhs.begin(), mhs.end(), [](Mhs a, Mhs b) {
        return a.get_ipk() > b.get_ipk();
    });

    for (int i = 0; i < k; i++) {
        cout << fixed << setprecision(2) << mhs[i].get_nim() << " " << mhs[i].get_ipk() << endl;
    }

    return 0;
}
