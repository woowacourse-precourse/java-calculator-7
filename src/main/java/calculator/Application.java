package calculator;

import calculator.service.StringSumCalculator;
import calculator.util.InputHandler;
import calculator.util.ErrorHandler;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 문자열 입력 요청
        String input = InputHandler.getInput(scanner);

        StringSumCalculator calculator = new StringSumCalculator();
        try {
            // 입력된 문자열의 합 계산
            int result = calculator.calculateSum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 잘못된 입력이 있을 경우 예외 처리
            throw e;
        } finally {
            scanner.close();
        }
    }
}
