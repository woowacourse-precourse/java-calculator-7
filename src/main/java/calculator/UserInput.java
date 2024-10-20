package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;

public class UserInput {
    public String getInput() {

        System.out.println(
                "덧셈할 문자열을 입력해주세요. " +
                        "(구분자를 커스텀하려면 '//'를 입력 한 뒤, 숫자를 제외한 문자를 입력후 엔터를 누르세요.)"
        );

        String input = Console.readLine();

        if (input.startsWith("//")) {
            String customDelimiter = input.substring(2, input.indexOf('\n'));

            if (customDelimiter.length() >= 2) {
                throw new IllegalArgumentException("커스텀 구분자는 하나의 문자로 입력해주세요.");
            }

            if (isNumeric(customDelimiter)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 문자로 입력해주세요.");
            }

            System.out.println("덧셈할 문자열을 입력해주세요.");
            input = Console.readLine();

        }

        return input;
    }

    private boolean isNumeric(String delimiter) {
        try {
            Double.parseDouble(delimiter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
