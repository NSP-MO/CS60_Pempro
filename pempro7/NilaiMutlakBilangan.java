import java.util.Scanner;

interface Number {
    double absoluteValue();
}

class Real implements Number {
    private double value;

    public Real(double value) {
        this.value = value;
    }

    @Override
    public double absoluteValue() {
        return Math.abs(value);
    }
}

class Rational implements Number {
    private int pembilang;
    private int penyebut;

    public Rational(int pembilang, int penyebut) {
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    @Override
    public double absoluteValue() {
        return Math.abs((double) pembilang / penyebut);
    }
}

class Complex implements Number {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public double absoluteValue() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
}

public class NilaiMutlakBilangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        double total = 0.0;

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            char type = parts[0].charAt(0);

            Number number = null;
            switch (type) {
                case 'R':
                    double realValue = Double.parseDouble(parts[1]);
                    number = new Real(realValue);
                    break;
                case 'P':
                    int pembilang = Integer.parseInt(parts[1]);
                    int penyebut = Integer.parseInt(parts[2]);
                    number = new Rational(pembilang, penyebut);
                    break;
                case 'C':
                    double real = Double.parseDouble(parts[1]);
                    double imaginary = Double.parseDouble(parts[2]);
                    number = new Complex(real, imaginary);
                    break;
            }
            total += number.absoluteValue();
        }

        System.out.printf("%.2f\n", total);
        scanner.close();
    }
}