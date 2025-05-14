package pempro5;
import java.util.Locale;
import java.util.Scanner;

public class InheritanceJava {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner inputReader = new Scanner(System.in);
        
        ShapeProcessor processor = new ShapeProcessor();
        
        while(inputReader.hasNextLine()) {
            String currentLine = inputReader.nextLine().strip();
            if(currentLine.equalsIgnoreCase("X")) break;
            processor.processLine(currentLine);
        }
        
        processor.displayResults();
        inputReader.close();
    }

    static abstract class Shape2D {
        abstract double calculateArea();
        abstract double calculatePerimeter();
    }

    static class Rectangle extends Shape2D {
        final double length;
        final double width;
        
        Rectangle(double l, double w) {
            length = l;
            width = w;
        }
        
        @Override
        double calculateArea() {
            return length * width;
        }
        
        @Override
        double calculatePerimeter() {
            return 2 * (length + width);
        }
    }

    static class RightTriangle extends Shape2D {
        final double base;
        final double height;
        
        RightTriangle(double b, double h) {
            base = b;
            height = h;
        }
        
        @Override
        double calculateArea() {
            return 0.5 * base * height;
        }
        
        @Override
        double calculatePerimeter() {
            double hypotenuse = Math.hypot(base, height);
            return base + height + hypotenuse;
        }
    }

    static class ShapeProcessor {
        private double rectAreaTotal = 0.0;
        private double triAreaTotal = 0.0;
        private double rectPerimeterTotal = 0.0;
        private double triPerimeterTotal = 0.0;

        void processLine(String line) {
            String[] components = line.split("\\s+");
            if(components.length < 3) return;
            
            String shapeType = components[0].toUpperCase();
            try {
                double paramA = Double.parseDouble(components[1]);
                double paramB = Double.parseDouble(components[2]);
                
                switch(shapeType) {
                    case "R":
                        handleRectangle(paramA, paramB);
                        break;
                    case "T":
                        handleTriangle(paramA, paramB);
                        break;
                }
            } catch(NumberFormatException ignored) {}
        }

        private void handleRectangle(double a, double b) {
            Rectangle rect = new Rectangle(a, b);
            rectAreaTotal += rect.calculateArea();
            rectPerimeterTotal += rect.calculatePerimeter();
        }

        private void handleTriangle(double a, double b) {
            RightTriangle triangle = new RightTriangle(a, b);
            triAreaTotal += triangle.calculateArea();
            triPerimeterTotal += triangle.calculatePerimeter();
        }

        void displayResults() {
            System.out.println("LUAS");
            System.out.printf("- Segiempat : %.2f\n", rectAreaTotal);
            System.out.printf("- Segitiga : %.2f\n", triAreaTotal);
            System.out.println("KELILING");
            System.out.printf("- Segiempat : %.2f\n", rectPerimeterTotal);
            System.out.printf("- Segitiga : %.2f\n", triPerimeterTotal);
        }
    }
}