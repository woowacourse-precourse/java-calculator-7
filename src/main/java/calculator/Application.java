package calculator;

import java.util.Scanner;

public class Application {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",|;");
        int sum = 0;

        try {
            for (String number : numbers) {
                sum += Integer.parseInt(number.trim());
            }
        } catch (NumberFormatException e) {
            System.out.println("not number");
            return 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int result = add(input);
        System.out.println("Sum: " + result);
    }
}
