import java.util.Scanner;

// Scientific Calculator Program
public class ScientificCalculator {

    // Mathematical constants
    static final double PI = Math.PI;
    static final double E = Math.E;

    // True = Degree mode, False = Radian mode
    static boolean isDegrees = true;

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Calculator heading
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       Scientific Calculator v1.0     ║");
        System.out.println("╚══════════════════════════════════════╝");

        // Main program loop
        while (true) {

            // Display menu
            printMenu();

            // Take user choice
            System.out.print("Enter choice: ");
            String choice = sc.nextLine().trim();

            // Exit condition
            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            // Execute selected operation
            handleChoice(choice, sc);
        }

        // Close scanner before ending program
        sc.close();
    }

    // Displays all available calculator operations
    static void printMenu() {
        // Menu printing code
    }

    // Handles menu choices entered by user
    static void handleChoice(String choice, Scanner sc) {
        try {
            switch (choice) {

                // Basic arithmetic operations
                case "1":
                    twoOp(sc, "+");
                    break;

                case "2":
                    twoOp(sc, "-");
                    break;

                case "3":
                    twoOp(sc, "*");
                    break;

                case "4":
                    twoOp(sc, "/");
                    break;

                // Toggle degree/radian mode
                case "31":
                    isDegrees = !isDegrees;
                    System.out.println(
                            "Switched to "
                                    + (isDegrees ? "DEGREES" : "RADIANS")
                                    + " mode.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        // Handles invalid number inputs
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number entered.");
        }

        // Handles mathematical errors
        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Reads a double value from user
    static double readDouble(Scanner sc, String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine().trim());
    }

    // Performs operations requiring two numbers
    static void twoOp(Scanner sc, String op) {

        // Read two operands
        double a = readDouble(sc, "Enter first number: ");
        double b = readDouble(sc, "Enter second number: ");

        double result;

        switch (op) {

            // Addition
            case "+":
                result = a + b;
                break;

            // Subtraction
            case "-":
                result = a - b;
                break;

            // Multiplication
            case "*":
                result = a * b;
                break;

            // Division
            case "/":
                if (b == 0)
                    throw new ArithmeticException("Division by zero.");
                result = a / b;
                break;

            // Modulo
            case "%":
                if (b == 0)
                    throw new ArithmeticException("Modulo by zero.");
                result = a % b;
                break;

            // Power operation (a^b)
            case "^":
                result = Math.pow(a, b);
                break;

            default:
                result = 0;
        }

        // Display result
        System.out.printf("Result: %.10g%n", result);
    }

    // Performs operations requiring one number
    static void oneOp(Scanner sc, String op) {

        // Read input value
        double a = readDouble(sc, "Enter number: ");

        double result;

        switch (op) {

            // Square root
            case "sqrt":
                if (a < 0)
                    throw new ArithmeticException(
                            "Cannot take sqrt of negative number.");
                result = Math.sqrt(a);
                break;

            // Sine function
            case "sin":
                result = Math.sin(toRad(a));
                break;

            // Cosine function
            case "cos":
                result = Math.cos(toRad(a));
                break;

            // Tangent function
            case "tan":
                result = Math.tan(toRad(a));
                break;

            // Absolute value
            case "abs":
                result = Math.abs(a);
                break;

            // Reciprocal (1/x)
            case "recip":
                if (a == 0)
                    throw new ArithmeticException(
                            "Cannot compute reciprocal of 0.");
                result = 1.0 / a;
                break;

            default:
                result = 0;
        }

        // Display result
        System.out.printf("Result: %.10g%n", result);
    }

    // Calculates nth root of a number
    static void nthRoot(Scanner sc) {

        double a = readDouble(sc, "Enter number: ");
        double n = readDouble(sc, "Enter root (n): ");

        if (n == 0)
            throw new ArithmeticException(
                    "Root degree cannot be zero.");

        double result = Math.pow(a, 1.0 / n);

        System.out.printf("Result: %.10g%n", result);
    }

    // Calculates logarithm with custom base
    static void logBaseN(Scanner sc) {

        double a = readDouble(sc, "Enter number: ");
        double b = readDouble(sc, "Enter base: ");

        double result = Math.log(a) / Math.log(b);

        System.out.printf("Result: %.10g%n", result);
    }

    // Calculates factorial using loop
    static void factorial(Scanner sc) {

        System.out.print("Enter non-negative integer: ");

        long n = Long.parseLong(sc.nextLine().trim());

        long result = 1;

        // Multiply numbers from 2 to n
        for (long i = 2; i <= n; i++)
            result *= i;

        System.out.println("Result: " + result);
    }

    // Calculates percentage of a value
    static void percentage(Scanner sc) {

        double x = readDouble(sc, "Enter percentage (%): ");
        double y = readDouble(sc, "Enter base value: ");

        double result = (x / 100.0) * y;

        System.out.printf("%.4g%% of %.4g = %.10g%n",
                x, y, result);
    }

    // Converts degrees to radians if Degree mode is enabled
    static double toRad(double angle) {
        return isDegrees ? Math.toRadians(angle) : angle;
    }

    // Converts radians to degrees if Degree mode is enabled
    static double fromRad(double rad) {
        return isDegrees ? Math.toDegrees(rad) : rad;
    }
}
