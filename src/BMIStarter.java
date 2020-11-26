import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print("What is username?");
        String username = scanner.nextLine();
        print("The username is " + username + ".");
        print("What is height of " + username + " in metres?");
        double height = scanner.nextDouble();
        while(height < 1.50 || height > 2.00) {
            printErr("The height must be between 1.50 and 2.00 metres.");
            height = scanner.nextDouble();
        }
        print("The height is " + height + ".");
        print("What is weight of " + username + " in kilograms?");
        double weight = scanner.nextDouble();
        while (weight < 45 || weight > 117) {
            printErr("The weight must be between 45 and 117 kilograms.");
            weight = scanner.nextDouble();
        }
        print("The weight is " + weight + ".");
        double bmi = weight / Math.pow(height, 2);
        print("The BMI is " + bmi + ".");
    }

    private static void print(String text) {
        System.out.println(text);
    }

    private static void printErr(String text) {
        System.err.println(text);
    }
}