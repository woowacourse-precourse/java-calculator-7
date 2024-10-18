package calculator.view;
import calculator.domain.repository.InputRepository;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements InputRepository<String> {
    public static String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public String input() {
        System.out.println(INPUT_MESSAGE);
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
