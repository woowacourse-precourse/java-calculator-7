package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Calculator calculator = new BasicCalculator(input);
        int result = calculator.calculate("add");
        System.out.println("결과 : " + result);
    }
}
