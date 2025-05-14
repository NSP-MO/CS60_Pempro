#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <iomanip>

using namespace std;

class Mhs {
public:
    Mhs(string nim) : NIM(nim), total_poin(0), total_sks(0) {}

    double get_IPK() const {
        return total_poin / total_sks;
    }

    void tambah_nilai(int sks, char nilai) {
        double nilai_val;
        switch (nilai) {
            case 'A': nilai_val = 4.0; break;
            case 'B': nilai_val = 3.0; break;
            case 'C': nilai_val = 2.0; break;
            case 'D': nilai_val = 1.0; break;
            case 'E': nilai_val = 0.0; break;
        }
        total_poin += sks * nilai_val;
        total_sks += sks;
    }

    string get_NIM() const {
        return NIM;
    }

private:
    string NIM;
    double total_poin;
    int total_sks;
};

bool operator<(const Mhs& a, const Mhs& b) {
    if (a.get_IPK() != b.get_IPK()) {
        return a.get_IPK() < b.get_IPK();
    } else {
        return a.get_NIM() > b.get_NIM();
    }
}

int main() {
    int N, K;
    cin >> N >> K;

    vector<Mhs> data;

    for (int i = 0; i < N; i++) {
        string nim;
        int T;
        cin >> nim >> T;

        Mhs mhs(nim);

        for (int j = 0; j < T; j++) {
            int sks;
            char h;
            cin >> sks >> h;

            mhs.tambah_nilai(sks, h);
        }

        data.push_back(mhs);
    }

    sort(data.begin(), data.end());
    reverse(data.begin(), data.end());

    for (int i = 0; i < K; i++) {
        Mhs& m = data[i];
        double ipk = m.get_IPK();
        cout << m.get_NIM() << " " << fixed << setprecision(2) << ipk << endl;
    }

    return 0;
}