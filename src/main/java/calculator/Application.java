package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String text = scanner.nextLine();

        StringCalculator calculator = new StringCalculator();
        try {
            int result = calculator.add(text);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
