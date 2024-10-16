package calculator;
import calculator.domain.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {
            try {
                promptUserForInput();
                String input = getInput();

                if (isExitCommand(input)) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                int result = Calculator.performAddition(input);
                System.out.println("결과 : " + result);

            } catch (IllegalArgumentException e) {
                System.out.println("입력 오류 : " + e.getMessage());
            }
        }
    }

    private static void promptUserForInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static boolean isExitCommand(String input) {
        // 대소문자 구분없이, input == exit 비교
        return "exit".equalsIgnoreCase(input);
    }
}
