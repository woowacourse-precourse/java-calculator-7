package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구분자와 양수로 구성된 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            InputValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
