package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int emptyInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열을 입력했다면,
        }
        return -1; // 정상적인 값을 넣었다면,
    }

    public static int add(String input) {
        int result = emptyInput(input);
        if (result != -1) {
            return result; // 빈 문자열이면 0 반환
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
