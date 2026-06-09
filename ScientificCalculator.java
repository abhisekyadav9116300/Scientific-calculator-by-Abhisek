import java.util.Scanner;

public class ScientificCalculator {

    // Mathematical constant representing Pi
    static final double PI = Math.PI;
    // Mathematical constant representing Euler's number
    static final double E = Math.E;
    // Determines whether trigonometric functions use Degrees or Radians
    static boolean isDegrees = true;

    // Main method - Program execution starts here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       Scientific Calculator v1.0     ║");
        System.out.println("╚══════════════════════════════════════╝");

        while (true) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = sc.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            handleChoice(choice, sc);
        }

        sc.close();
    }

    // Displays all available calculator operations
    static void printMenu() {
        System.out.println("\n──────────────────────────────────────");
        System.out.println(" BASIC OPERATIONS");
        System.out.println("  1. Add          2. Subtract");
        System.out.println("  3. Multiply     4. Divide");
        System.out.println("  5. Modulo       6. Power (x^y)");
        System.out.println("\n ROOTS & LOGARITHMS");
        System.out.println("  7. Square Root  8. Cube Root");
        System.out.println("  9. nth Root    10. Log (base 10)");
        System.out.println(" 11. Natural Log 12. Log (base n)");
        System.out.println("\n TRIGONOMETRY  [mode: " + (isDegrees ? "DEGREES" : "RADIANS") + "]");
        System.out.println(" 13. sin        14. cos        15. tan");
        System.out.println(" 16. asin       17. acos       18. atan");
        System.out.println(" 19. sinh       20. cosh       21. tanh");
        System.out.println("\n CONSTANTS & EXTRAS");
        System.out.println(" 22. π (Pi)     23. e (Euler)");
        System.out.println(" 24. Factorial  25. Absolute Value");
        System.out.println(" 26. Ceil       27. Floor");
        System.out.println(" 28. Round      29. Reciprocal (1/x)");
        System.out.println(" 30. Percentage (x% of y)");
        System.out.println("\n SETTINGS");
        System.out.println(" 31. Toggle Degrees / Radians");
        System.out.println("  0. Exit");
        System.out.println("──────────────────────────────────────");
    }

    // Processes user choice and calls the corresponding operation
    static void handleChoice(String choice, Scanner sc) {
        try {
            switch (choice) {
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
                case "5":
                    twoOp(sc, "%");
                    break;
                case "6":
                    twoOp(sc, "^");
                    break;
                case "7":
                    oneOp(sc, "sqrt");
                    break;
                case "8":
                    oneOp(sc, "cbrt");
                    break;
                case "9":
                    nthRoot(sc);
                    break;
                case "10":
                    oneOp(sc, "log10");
                    break;
                case "11":
                    oneOp(sc, "ln");
                    break;
                case "12":
                    logBaseN(sc);
                    break;
                case "13":
                    oneOp(sc, "sin");
                    break;
                case "14":
                    oneOp(sc, "cos");
                    break;
                case "15":
                    oneOp(sc, "tan");
                    break;
                case "16":
                    oneOp(sc, "asin");
                    break;
                case "17":
                    oneOp(sc, "acos");
                    break;
                case "18":
                    oneOp(sc, "atan");
                    break;
                case "19":
                    oneOp(sc, "sinh");
                    break;
                case "20":
                    oneOp(sc, "cosh");
                    break;
                case "21":
                    oneOp(sc, "tanh");
                    break;
                case "22":
                    System.out.printf("π = %.10f%n", PI);
                    break;
                case "23":
                    System.out.printf("e = %.10f%n", E);
                    break;
                case "24":
                    factorial(sc);
                    break;
                case "25":
                    oneOp(sc, "abs");
                    break;
                case "26":
                    oneOp(sc, "ceil");
                    break;
                case "27":
                    oneOp(sc, "floor");
                    break;
                case "28":
                    oneOp(sc, "round");
                    break;
                case "29":
                    oneOp(sc, "recip");
                    break;
                case "30":
                    percentage(sc);
                    break;
                case "31":
                    isDegrees = !isDegrees;
                    System.out.println("Switched to " + (isDegrees ? "DEGREES" : "RADIANS") + " mode.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number entered.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Reads a double value from the user
    static double readDouble(Scanner sc, String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine().trim());
    }

    // Performs operations that require two operands
    static void twoOp(Scanner sc, String op) {
        double a = readDouble(sc, "Enter first number: ");
        double b = readDouble(sc, "Enter second number: ");
        double result;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0)
                    throw new ArithmeticException("Division by zero.");
                result = a / b;
                break;
            case "%":
                if (b == 0)
                    throw new ArithmeticException("Modulo by zero.");
                result = a % b;
                break;
            case "^":
                result = Math.pow(a, b);
                break;
            default:
                result = 0;
        }
        System.out.printf("Result: %.10g%n", result);
    }

    // Performs operations that require a single operand
    static void oneOp(Scanner sc, String op) {
        double a = readDouble(sc, "Enter number: ");
        double result;
        switch (op) {
            case "sqrt":
                if (a < 0)
                    throw new ArithmeticException("Cannot take sqrt of negative number.");
                result = Math.sqrt(a);
                break;
            case "cbrt":
                result = Math.cbrt(a);
                break;
            case "log10":
                if (a <= 0)
                    throw new ArithmeticException("Logarithm undefined for non-positive numbers.");
                result = Math.log10(a);
                break;
            case "ln":
                if (a <= 0)
                    throw new ArithmeticException("Logarithm undefined for non-positive numbers.");
                result = Math.log(a);
                break;
            case "sin":
                result = Math.sin(toRad(a));
                break;
            case "cos":
                result = Math.cos(toRad(a));
                break;
            case "tan":
                result = Math.tan(toRad(a));
                if (Double.isInfinite(result))
                    throw new ArithmeticException("tan undefined at ±90°.");
                break;
            case "asin":
                if (a < -1 || a > 1)
                    throw new ArithmeticException("asin domain: [-1, 1].");
                result = fromRad(Math.asin(a));
                break;
            case "acos":
                if (a < -1 || a > 1)
                    throw new ArithmeticException("acos domain: [-1, 1].");
                result = fromRad(Math.acos(a));
                break;
            case "atan":
                result = fromRad(Math.atan(a));
                break;
            case "sinh":
                result = Math.sinh(a);
                break;
            case "cosh":
                result = Math.cosh(a);
                break;
            case "tanh":
                result = Math.tanh(a);
                break;
            case "abs":
                result = Math.abs(a);
                break;
            case "ceil":
                result = Math.ceil(a);
                break;
            case "floor":
                result = Math.floor(a);
                break;
            case "round":
                result = Math.round(a);
                break;
            case "recip":
                if (a == 0)
                    throw new ArithmeticException("Cannot compute reciprocal of 0.");
                result = 1.0 / a;
                break;
            default:
                result = 0;
        }
        System.out.printf("Result: %.10g%n", result);
    }

    // Calculates the nth root of a number
    static void nthRoot(Scanner sc) {
        double a = readDouble(sc, "Enter number: ");
        double n = readDouble(sc, "Enter root (n): ");
        if (n == 0)
            throw new ArithmeticException("Root degree cannot be zero.");
        double result = Math.pow(a, 1.0 / n);
        System.out.printf("Result: %.10g%n", result);
    }

    // Calculates logarithm with a user-defined base
    static void logBaseN(Scanner sc) {
        double a = readDouble(sc, "Enter number: ");
        double b = readDouble(sc, "Enter base: ");
        if (a <= 0)
            throw new ArithmeticException("Logarithm undefined for non-positive numbers.");
        if (b <= 0 || b == 1)
            throw new ArithmeticException("Base must be positive and not equal to 1.");
        double result = Math.log(a) / Math.log(b);
        System.out.printf("Result: %.10g%n", result);
    }

    // Calculates factorial of a non-negative integer
    static void factorial(Scanner sc) {
        System.out.print("Enter non-negative integer: ");
        long n = Long.parseLong(sc.nextLine().trim());
        if (n < 0)
            throw new ArithmeticException("Factorial undefined for negative numbers.");
        if (n > 20)
            throw new ArithmeticException("Input too large (max 20 to avoid overflow).");
        long result = 1;
        for (long i = 2; i <= n; i++)
            result *= i;
        System.out.println("Result: " + result);
    }

    // Calculates percentage value
    static void percentage(Scanner sc) {
        double x = readDouble(sc, "Enter percentage (%): ");
        double y = readDouble(sc, "Enter base value: ");
        double result = (x / 100.0) * y;
        System.out.printf("%.4g%% of %.4g = %.10g%n", x, y, result);
    }

    // Converts degrees to radians when degree mode is enabled
    static double toRad(double angle) {
        return isDegrees ? Math.toRadians(angle) : angle;
    }

    // Converts radians to degrees when degree mode is enabled
    static double fromRad(double rad) {
        return isDegrees ? Math.toDegrees(rad) : rad;
    }
}
