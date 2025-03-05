import java.util.Scanner;

interface Bangun {
    double hitungLuas();
}

interface Bangun3D extends Bangun {
    double hitungVolume();
}

class Persegi implements Bangun {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }
}

class Lingkaran implements Bangun {
    private double radius;
    private static final double PI = 3.1425;

    public Lingkaran(double radius) {
        this.radius = radius;
    }

    @Override
    public double hitungLuas() {
        return PI * radius * radius;
    }
}

class Kubus implements Bangun3D {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return 6 * sisi * sisi;
    }

    @Override
    public double hitungVolume() {
        return sisi * sisi * sisi;
    }
}

class Bola implements Bangun3D {
    private double radius;
    private static final double PI = 3.1425;

    public Bola(double radius) {
        this.radius = radius;
    }

    @Override
    public double hitungLuas() {
        return 4 * PI * radius * radius;
    }

    @Override
    public double hitungVolume() {
        return (4.0 / 3.0) * PI * radius * radius * radius;
    }
}

public class PolimorfismeJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumlahObjek = scanner.nextInt();
        double totalLuas = 0.0;
        double totalVolume = 0.0;

        for (int i = 0; i < jumlahObjek; i++) {
            String kode = scanner.next();
            double nilai = scanner.nextDouble();

            Bangun objek = null;

            switch (kode) {
                case "P":
                    objek = new Persegi(nilai);
                    break;
                case "L":
                    objek = new Lingkaran(nilai);
                    break;
                case "K":
                    objek = new Kubus(nilai);
                    break;
                case "B":
                    objek = new Bola(nilai);
                    break;
                default:
                    System.out.println("Kode tidak valid!");
                    System.exit(1);
            }

            totalLuas += objek.hitungLuas();

            if (objek instanceof Bangun3D) {
                Bangun3D objek3D = (Bangun3D) objek;
                totalVolume += objek3D.hitungVolume();
            }
        }

        System.out.printf("%.2f%n", totalLuas);
        System.out.printf("%.2f%n", totalVolume);
        
        scanner.close();
    }
}