package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        // scanner 변수 선언
        Scanner scanner = new Scanner(System.in);

        // 숫자의 합을 저장할 변수 선언
        int answer = 0;

        try {

            // 문자열 입력
            System.out.println("문자열을 입력하세요: ");

            String input = scanner.next();

            // 구분자를 기준으로 문자열을 자름
            String[] numbers = input.split(",|:");

            // 분리된 문자열을 숫자로 변환하여 출력
            for (String numberStr : numbers) {
                try {
                    int number = Integer.parseInt(numberStr.trim());  // 숫자로 변환
                    answer += number;
                } catch (NumberFormatException e) {
                    // 숫자가 아닌 부분은 무시하거나 오류 처리
                    System.err.println("유효하지 않은 숫자: " + numberStr);
                    System.exit(1);
                }
            }
            // 문자열 출력
            System.out.println("입력한 문자열: " + input);

            // 정답 출력
            System.out.println("정답: " + answer);

            scanner.close();

        } catch (IllegalArgumentException e) {
            System.err.println("오류 : " + e.getMessage());
            System.exit(1);
        } finally {
            scanner.close();
        }
    }
}
