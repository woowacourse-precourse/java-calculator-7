package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 표준 입력에서 문자열을 읽어옵니다.
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int result = StringCalculator.splitAndSum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 애플리케이션을 종료합니다.
            throw e;
        }
    }
}
