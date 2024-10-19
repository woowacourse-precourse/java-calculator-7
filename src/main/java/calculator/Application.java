package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

class StringAddCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimeter = ",|:";
        if (input.startsWith("//")) {
            int delimeterEndIndex = input.indexOf("\\n");
            if (delimeterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }
            delimeter = Pattern.quote(input.substring(2, delimeterEndIndex));
            input = input.substring(delimeterEndIndex + 2);
        }

        String[] numbers = input.split(delimeter);
        int result = 0;
        for (String numString : numbers) {
            try {
                int number = Integer.parseInt(numString);
                if (number < 0) {
                    throw new IllegalArgumentException("음수 값이 입력되었습니다: " + number);
                }
                result += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다: " + numString);
            }
        }
        return result;
    }
}


public class Application {
    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        int result = stringAddCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}
