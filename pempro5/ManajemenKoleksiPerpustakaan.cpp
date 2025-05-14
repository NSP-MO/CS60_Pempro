#include <iostream>
#include <string>
#include <sstream>
#include <unordered_map>
#include <vector>
#include <algorithm>

using namespace std;

class Koleksi {
public:
    string ID;
    char jenis;
    long long totalSalinan;
    long long salinan;

    Koleksi(string id, char j, long long copies) : ID(id), jenis(j), totalSalinan(copies), salinan(copies) {}
};

class Perpustakaan {
private:
    unordered_map<string, Koleksi> koleksiMap;

public:
    void tambahKoleksi(string id, char jenis, long long copies) {
        koleksiMap.emplace(id, Koleksi(id, jenis, copies));
    }

    bool pinjamKoleksi(string id) {
        auto it = koleksiMap.find(id);
        if (it == koleksiMap.end()) {
            return false;
        }
        Koleksi& k = it->second;
        if (k.salinan > 0) {
            k.salinan--;
            return true;
        } else {
            return false;
        }
    }

    void kembaliKoleksi(string id) {
        auto it = koleksiMap.find(id);
        if (it != koleksiMap.end()) {
            Koleksi& k = it->second;
            k.salinan = min(k.salinan + 1, k.totalSalinan);
        }
    }

    void listKoleksi(long long& totalJudul, long long& buku, long long& majalah, long long& karya, long long& totalSalinan) {
        totalJudul = koleksiMap.size();
        buku = 0;
        majalah = 0;
        karya = 0;
        totalSalinan = 0;

        for (auto& pair : koleksiMap) {
            Koleksi& k = pair.second;
            switch(k.jenis) {
                case 'B': buku++; break;
                case 'M': majalah++; break;
                case 'K': karya++; break;
            }
            totalSalinan += k.salinan;
        }
    }
};

int main() {
    long long N, K;
    cin >> N >> K;
    cin.ignore();

    Perpustakaan perpus;

    for (long long i = 0; i < N; ++i) {
        string line;
        getline(cin, line);
        istringstream iss(line);
        string id;
        char j;
        long long copies;
        iss >> id >> j >> copies;
        perpus.tambahKoleksi(id, j, copies);
    }

    for (long long i = 0; i < K; ++i) {
        string line;
        getline(cin, line);
        istringstream iss(line);
        vector<string> tokens;
        string token;
        while (iss >> token) {
            tokens.push_back(token);
        }

        string cmd = tokens[0];
        if (cmd == "PINJAM") {
            string id = tokens[1];
            bool success = perpus.pinjamKoleksi(id);
            cout << "PEMINJAMAN " << id << " " << (success ? "BERHASIL" : "GAGAL") << endl;
        } else if (cmd == "TAMBAH") {
            string id = tokens[1];
            char j = tokens[2][0];
            long long copies = stoll(tokens[3]);
            perpus.tambahKoleksi(id, j, copies);
            cout << "PENAMBAHAN KOLEKSI " << id << " JUMLAH = " << copies << endl;
        } else if (cmd == "KOLEKSI") {
            long long totalJudul, buku, majalah, karya, totalSalinan;
            perpus.listKoleksi(totalJudul, buku, majalah, karya, totalSalinan);
            cout << "BANYAK KOLEKSI = " << totalJudul << " JUDUL (BUKU = " << buku << ", MAJALAH = " << majalah << ", KARYA ILMIAH = " << karya << ", TOTAL = " << totalSalinan << ")" << endl;
        } else if (cmd == "KEMBALI") {
            string id = tokens[1];
            perpus.kembaliKoleksi(id);
            cout << "PENGEMBALIAN " << id << endl;
        }
    }

    return 0;
}
