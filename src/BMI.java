import java.util.Scanner;

public class BMI {
    private String username;
    private double height;
    private double weight;
    private double index;

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
    }

    public void init(String username, double height, double weight) {
        this.username = username;
        this.height = height;
        this.weight = weight;
    }

    public String process() {
        index = weight / Math.pow(height, 2);
        final String result;
        if (index < 18.5) {
            result = "Underweight.";
        } else if (index >= 18.5 && index < 25) {
            result = "Normal weight.";
        } else if (index >= 25 && index < 30) {
            result = "Overweight.";
        } else if (index >= 30 && index < 35) {
            result = "Obese.";
        } else {
            result = "Extremely obese.";
        }

        return result;
    }

    private void print(String text) {
        System.out.println(text);
    }

    private void printErr(String text) {
        System.err.println(text);
    }
}