import java.util.Scanner;

public class BMI {
    private String username;
    private double i;

    public void init() {
        Scanner scanner = new Scanner(System.in);
        print("What is username?");
        username = scanner.nextLine();
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
        i = weight / Math.pow(height, 2);
    }

    public void print() {
        String result;
        if (i < 18.5) {
            result = "Underweight.";
        } else if (i >= 18.5 && i < 25) {
            result = "Normal weight.";
        } else if (i >= 25 && i < 30) {
            result = "Overweight.";
        } else if (i >= 30 && i < 35) {
            result = "Obese.";
        } else {
            result = "Extremely obese.";
        }

        print("Mass " + username + ":" + result);
    }

    private void print(String text) {
        System.out.println(text);
    }

    private void printErr(String text) {
        System.err.println(text);
    }
}