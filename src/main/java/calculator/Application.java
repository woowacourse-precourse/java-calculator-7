package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
