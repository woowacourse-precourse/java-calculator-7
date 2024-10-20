package calculator;

import calculator.exception.InvalidInputException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요.");

        String input = scanner.nextLine();
        try {
            int result = Integer.parseInt(StringCalculator.calculate(input));
            System.out.println("결과 : " + result);
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
        }
    }
}
