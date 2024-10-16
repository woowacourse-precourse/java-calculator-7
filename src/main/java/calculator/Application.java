package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        // 결과 출력하는 로직
        try {
            int result = StringAddCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // 스캐너 자원 해제
        scanner.close();
    }
}


