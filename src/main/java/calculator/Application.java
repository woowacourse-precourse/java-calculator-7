package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 입력을 받기 위한 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();  // 문자열 덧셈 계산기 객체 생성

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();  // 사용자 입력 받기

        try {
            int result = calculator.add(input);  // 입력 값을 처리하고 결과 계산
            System.out.println("결과: " + result);  // 결과 출력
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
