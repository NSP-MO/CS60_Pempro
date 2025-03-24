#include <bits/stdc++.h>

using namespace std;

class Orang {
    public:
    char gender;
    int age;

    Orang(char g, int a) : gender(g), age(a) {}
};

class Pegawai : public Orang {
    public:
    string nip;
    string name;
    Pegawai(string n, string p, char g, int a) : Orang(g, a), name(n), nip(p) {}
};

class Mhs : public Orang {
    public:
    string nim;
    Mhs(string n, char g, int a) : Orang(g, a), nim(n) {}
};

int main() {
    int N;
    cin >> N;
    unordered_map<string, Orang*> data;
    for (int i = 0; i < N; ++i) {
        string id, name;
        char gender;
        int age;
        cin >> id;
        if (id.length() == 9) {
            cin >> gender >> age;
            data[id] = new Mhs(id, gender, age);
        } else {
            cin >> name >> gender >> age;
            data[id] = new Pegawai(name, id, gender, age);
        }
    }

    int Q;
    cin >> Q;
    int sum_male = 0, count_male = 0;
    int sum_female = 0, count_female = 0;

    for (int i = 0; i < Q; ++i) {
        string id;
        cin >> id;
        if (data.find(id) != data.end()) {
            Orang* o = data[id];
            if (o->gender == 'L') {
                sum_male += o->age;
                count_male++;
            } else if (o->gender == 'P') {
                sum_female += o->age;
                count_female++;
            }
        }
    }

    double avg_male = count_male ? static_cast<double>(sum_male) / count_male : 0.0;
    double avg_female = count_female ? static_cast<double>(sum_female) / count_female : 0.0;

    cout << fixed << setprecision(2) << avg_male << " " << avg_female << endl;

    for (auto& entry : data) {
        delete entry.second;
    }

    return 0;
}
