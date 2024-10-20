package calculator.view;

import calculator.domain.Number;
import calculator.util.Parser;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorView {

    public static String requestAddCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("\\n", "\n");
        validateInput(input);
        return input;
    }

    public static void responseResult(Number result) {
        System.out.printf("결과 : %d", result.getValue());
    }

    private static void validateInput(String input) {
        String regex = "^(?://.\n)?(?:\\d[:," + Parser.parseCustomDelimiter(input) + "])*\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
        }
    }
}
