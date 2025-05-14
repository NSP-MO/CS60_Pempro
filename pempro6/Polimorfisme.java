import java.util.Scanner;

interface Bentuk {
    double hitungLuas();
}

interface Bentuk3D {
    double hitungVolume();
}

class Persegi implements Bentuk {
    private double panjangSisi;

    public Persegi(double panjangSisi) {
        this.panjangSisi = panjangSisi;
    }

    @Override
    public double hitungLuas() {
        return panjangSisi * panjangSisi;
    }
}

class Lingkaran implements Bentuk {
    private double jariJari;
    private static final double NILAI_PI = 3.1425;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return NILAI_PI * jariJari * jariJari;
    }
}

class Kubus implements Bentuk, Bentuk3D {
    private double panjangSisi;

    public Kubus(double panjangSisi) {
        this.panjangSisi = panjangSisi;
    }

    @Override
    public double hitungLuas() {
        return 6 * panjangSisi * panjangSisi;
    }

    @Override
    public double hitungVolume() {
        return Math.pow(panjangSisi, 3);
    }
}

class Bola implements Bentuk, Bentuk3D {
    private double jariJari;
    private static final double NILAI_PI = 3.1425;

    public Bola(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return 4 * NILAI_PI * jariJari * jariJari;
    }

    @Override
    public double hitungVolume() {
        return (4.0 / 3.0) * NILAI_PI * Math.pow(jariJari, 3);
    }
}

public class Polimorfisme {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahBentuk = input.nextInt();
        double totalLuasSemua = 0.0;
        double totalVolumeSemua = 0.0;

        for (int indeks = 0; indeks < jumlahBentuk; indeks++) {
            String kodeBentuk = input.next();
            double ukuran = input.nextDouble();

            Bentuk bentuk = null;

            switch (kodeBentuk) {
                case "P":
                    bentuk = new Persegi(ukuran);
                    break;
                case "L":
                    bentuk = new Lingkaran(ukuran);
                    break;
                case "K":
                    bentuk = new Kubus(ukuran);
                    break;
                case "B":
                    bentuk = new Bola(ukuran);
                    break;
                default:
                    System.out.println("Input salah!");
                    System.exit(1);
            }

            totalLuasSemua += bentuk.hitungLuas();

            if (bentuk instanceof Bentuk3D) {
                Bentuk3D bentuk3D = (Bentuk3D) bentuk;
                totalVolumeSemua += bentuk3D.hitungVolume();
            }
        }

        System.out.printf("%.2f%n", totalLuasSemua);
        System.out.printf("%.2f%n", totalVolumeSemua);
        
        input.close();
    }
}

