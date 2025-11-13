import java.util.Scanner;

public class QuadraticSolver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Scanner renamed to 'input'

        System.out.print("Enter coefficients a, b, and c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        if (a == 0) {
            System.out.println("Coefficient 'a' cannot be zero.");
            input.close();
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two real roots:");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root:");
            System.out.println("Root = " + root);
        } else {
            System.out.println("No real roots.");
        }

        input.close();
    }
}
