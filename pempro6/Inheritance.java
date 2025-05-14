import java.util.Locale;
import java.util.Scanner;

public class Inheritance {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        double totalLuasSegiempat = 0.0;
        double totalLuasSegitiga = 0.0;
        double totalKelilingSegiempat = 0.0;
        double totalKelilingSegitiga = 0.0;

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equals("X")) {
                break;
            }

            String[] parts = line.split("\\s+");
            if (parts.length < 3) {
                continue;
            }

            String tipe = parts[0];
            if (!tipe.equals("R") && !tipe.equals("T")) {
                continue;
            }

            try {
                // Trim setiap bagian untuk menghilangkan spasi tambahan
                double param1 = Double.parseDouble(parts[1].trim());
                double param2 = Double.parseDouble(parts[2].trim());

                if (tipe.equals("R")) {
                    Segiempat segi = new Segiempat(param1, param2);
                    totalLuasSegiempat += segi.hitungLuas();
                    totalKelilingSegiempat += segi.hitungKeliling();
                } else if (tipe.equals("T")) {
                    Segitiga segi = new Segitiga(param1, param2);
                    totalLuasSegitiga += segi.hitungLuas();
                    totalKelilingSegitiga += segi.hitungKeliling();
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        System.out.println("LUAS");
        System.out.printf("- Segiempat : %.2f\n", totalLuasSegiempat);
        System.out.printf("- Segitiga : %.2f\n", totalLuasSegitiga);
        System.out.println("KELILING");
        System.out.printf("- Segiempat : %.2f\n", totalKelilingSegiempat);
        System.out.printf("- Segitiga : %.2f\n", totalKelilingSegitiga);
    }

    abstract static class Ruang2D {
        public abstract double hitungLuas();
        public abstract double hitungKeliling();
    }

    static class Segiempat extends Ruang2D {
        private double panjang;
        private double lebar;

        public Segiempat(double panjang, double lebar) {
            this.panjang = panjang;
            this.lebar = lebar;
        }

        @Override
        public double hitungLuas() {
            return panjang * lebar;
        }

        @Override
        public double hitungKeliling() {
            return 2 * (panjang + lebar);
        }
    }

    static class Segitiga extends Ruang2D {
        private double alas;
        private double tinggi;

        public Segitiga(double alas, double tinggi) {
            this.alas = alas;
            this.tinggi = tinggi;
        }

        @Override
        public double hitungLuas() {
            return 0.5 * alas * tinggi;
        }

        @Override
        public double hitungKeliling() {
            double sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
            return alas + tinggi + sisiMiring;
        }
    }
}





