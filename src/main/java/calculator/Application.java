package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        // 출력
        Integer result = StringCalculator.calculate(input);
        System.out.printf("결과 : %d%n", result);

        // 자원 해제
        scanner.close();
    }
}
