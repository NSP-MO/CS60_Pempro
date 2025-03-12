import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Bidang {
    public abstract double hitungLuas();
}

class Lingkaran extends Bidang {
    private double radius;

    public Lingkaran(double radius) {
        this.radius = radius;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * radius * radius;
    }
}

class Silinder extends Bidang {
    private double radius;
    private double tinggi;

    public Silinder(double radius, double tinggi) {
        this.radius = radius;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return 2 * Math.PI * radius * (radius + tinggi);
    }
}

public class LuasPermukaanLingkaranSilinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Bidang> bidangs = new ArrayList<>();
        double[] areas = new double[N];

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            char type = parts[0].charAt(0);
            Bidang bidang;

            if (type == 'L') {
                double radius = Double.parseDouble(parts[1]);
                bidang = new Lingkaran(radius);
            } else {
                double radius = Double.parseDouble(parts[1]);
                double tinggi = Double.parseDouble(parts[2]);
                bidang = new Silinder(radius, tinggi);
            }

            bidangs.add(bidang);
            areas[i] = bidang.hitungLuas();
        }

        double[] prefix = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + areas[i - 1];
        }

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equals("-1")) {
                break;
            }
            String[] parts = line.split("\\s+");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            double sum = prefix[b] - prefix[a - 1];
            System.out.printf("%.2f\n", sum);
        }

        scanner.close();
    }
}