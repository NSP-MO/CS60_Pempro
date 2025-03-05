package pempro5;
import java.util.Scanner;

public class IOJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[] values = new double[N];
        
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextDouble();
        }
        
        double min = values[0];
        double max = values[0];
        double sum = 0.0;
        
        for (double value : values) {
            if (value < min) min = value;
            if (value > max) max = value;
            sum += value;
        }
        
        double average = sum / N;
        double sumSquaredDiffs = 0.0;
        
        for (double value : values) {
            sumSquaredDiffs += Math.pow(value - average, 2);
        }
        
        double stdev;
        if (N == 1) {
            stdev = 0.0;
        } else {
            stdev = Math.sqrt(sumSquaredDiffs / (N - 1));
        }
        
        System.out.printf("%.2f %.2f%n", min, max);
        System.out.printf("%.2f %.2f%n", average, stdev);
    }
}