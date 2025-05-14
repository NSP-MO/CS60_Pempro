#include<bits/stdc++.h>

using namespace std;

class Koleksi 
{
public:
    string id;
    char jenis;
    int jumlah;

    Koleksi(string id, char jenis, int jumlah) 
    {
        this->id = id;
        this->jenis = jenis;
        this->jumlah = jumlah;
    }

    string getID() {
        return id;
    }

    char getJenis() {
        return jenis;
    }

    int getJumlah() {
        return jumlah;
    }

    void kurangijumlah() {
        jumlah--;
    }
    void tambahjumlah(){
        jumlah++;
    }
};

class Perpustakaan 
{
    map<string, Koleksi*> koleksi;

public:
    void tambahKoleksi(string id, char jenis, int jumlah) 
    {
        Koleksi* k = new Koleksi(id, jenis, jumlah);
        koleksi[id] = k;
    }

    string pinjamKoleksi(string ID) 
    {
        if (koleksi.find(ID) != koleksi.end() && koleksi[ID]->getJumlah() > 0) 
        {
            koleksi[ID]->kurangijumlah();
            return "PEMINJAMAN " + ID + " BERHASIL";
        } else {
            return "PEMINJAMAN " + ID + " GAGAL";
        }
    }

    void kembaliKoleksi(string ID) 
    {
        if (koleksi.find(ID) != koleksi.end()) 
        {
            koleksi[ID]->tambahjumlah();
            cout << "PENGEMBALIAN " << ID << endl;
        }
    }

    string listKoleksi() 
    {
        int total = 0, buku = 0, majalah = 0, karyailmiah = 0;

        for (auto& pair : koleksi) {
            total += pair.second->getJumlah();
            if (pair.second->getJenis() == 'B') 
            {
                buku++;
            } 
            else if (pair.second->getJenis() == 'M') 
            {
                majalah++;
            } 
            else 
            {
                karyailmiah++;
            }
        }

        return "BANYAK KOLEKSI = " + to_string(buku+majalah+karyailmiah) + " JUDUL (BUKU = " + to_string(buku) + ", MAJALAH = " + to_string(majalah) + ", KARYA ILMIAH = " + to_string(karyailmiah) + ", TOTAL = " + to_string(total) + ")";
    }
};

int main()
{
    int N, K;
    cin >> N >> K;

    Perpustakaan perpustakaan;

    for (int i = 0; i < N; i++) 
    {
        string id;
        char jenis;
        int jumlah;
        cin >> id >> jenis >> jumlah;
        perpustakaan.tambahKoleksi(id, jenis, jumlah);
    }

    string kejadian, id;
    int jumlah;
    char jenis;

    for (int i = 0; i < K; ++i) 
    {
        string kejadian;
        cin >> kejadian;

        if (kejadian == "PINJAM") 
        {
            string ID;
            cin >> ID;
            cout << perpustakaan.pinjamKoleksi(ID) << endl;
        } 
        
        else if (kejadian == "TAMBAH") 
        {
            string ID;
            char jenis;
            int jumlah;
            cin >> ID >> jenis >> jumlah;
            perpustakaan.tambahKoleksi(ID, jenis, jumlah);
            cout << "PENAMBAHAN KOLEKSI " << ID << " JUMLAH = " << jumlah << endl;
        } 
        
        else if (kejadian == "KEMBALI") 
        {
            string ID;
            cin >> ID;
            perpustakaan.kembaliKoleksi(ID);
        } 
        
        else if (kejadian == "KOLEKSI") 
        {
            cout << perpustakaan.listKoleksi() << endl;
        }
    }

    return 0;
}