package pempro5;
import java.util.Arrays;
import java.util.Scanner;

class Mhs implements Comparable<Mhs> {
    private String NIM;
    private double total_ipk;
    private int total_sks;

    public Mhs(String NIM) {
        this.NIM = NIM;
        this.total_ipk = 0.0;
        this.total_sks = 0;
    }

    public void tambah_nilai(int sks, char hm) {
        double nilai_val = 0.0;
        switch (hm) {
            case 'A': nilai_val = 4.0; break;
            case 'B': nilai_val = 3.0; break;
            case 'C': nilai_val = 2.0; break;
            case 'D': nilai_val = 1.0; break;
            case 'E': nilai_val = 0.0; break;
            default:
                break;
        }
        total_ipk += sks * nilai_val;
        total_sks += sks;
    }

    public double getIPK() {
        if (total_sks == 0) return 0.0;
        return total_ipk / total_sks;
    }

    public String getNIM() {
        return NIM;
    }

    @Override
    public int compareTo(Mhs m2) {
        int compareIPK = Double.compare(m2.getIPK(), this.getIPK());
        if (compareIPK == 0) {
            return this.getNIM().compareTo(m2.getNIM());
        }
        return compareIPK;
    }
}

public class IPKOOPJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Mhs[] data = new Mhs[N];

        for (int i = 0; i < N; i++) {
            String NIM = scanner.next();
            int T = scanner.nextInt();
            Mhs mhs = new Mhs(NIM);

            for (int j = 0; j < T; j++) {
                int sks = scanner.nextInt();
                char hm = scanner.next().charAt(0);
                mhs.tambah_nilai(sks, hm);
            }

            data[i] = mhs;
        }

        Arrays.sort(data);

        for (int i = 0; i < K && i < data.length; i++) {
            Mhs m = data[i];
            System.out.printf("%s %.2f%n", m.getNIM(), m.getIPK());
        }
    }
}