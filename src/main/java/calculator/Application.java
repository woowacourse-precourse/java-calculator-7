package calculator;
import static calculator.Converter.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        String customDelimiter = Validator.findCustomDelimiter(input);
        input = removeCustomDelimiterAndSpace(input, customDelimiter);
        String[] strings = convertToArray(input);

    }
}
