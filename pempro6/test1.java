import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter length of side: ");
        double side = input.nextDouble();

        double area = 6 * Math.pow(side, 2);

        System.out.println("Area of cube is: " + area);
    }
}
