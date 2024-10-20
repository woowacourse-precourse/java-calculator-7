package calculator;

import java.util.Scanner;

public class Application {

    // 테스트 환경을 구분하기 위한 플래그
    private static boolean isTestMode = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();

        while (true) {
            System.out.println("덧셈할 문자열을 입력해 주세요. (종료하려면 'exit' 입력)");
            String input = scanner.nextLine();

            // 입력이 'exit'이면 프로그램을 종료합니다.
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                // 계산 수행
                int result = calculator.add(input);
                System.out.println("결과 : " + result);
                break;  // 정상적으로 결과가 나오면 반복문 종료
            } catch (IllegalArgumentException e) {
                // 예외 발생 시 메시지를 출력
                System.out.println("잘못된 입력값: " + e.getMessage());

                // 테스트 모드일 경우에는 예외를 다시 던짐 (테스트 코드에서 예외를 잡기 위해)
                if (isTestMode) {
                    throw e;  // 예외를 다시 던짐으로써 테스트에서 검증 가능하게 함
                } else {
                    // 실제 실행에서는 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }
        }
        scanner.close();
    }

    // 테스트에서 이 메서드를 호출하여 테스트 모드로 변경
    public static void setTestMode(boolean testMode) {
        isTestMode = testMode;
    }
}