package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Character customSeparator = SeparatorManager.getCustomSeparator(input);
        if(customSeparator != null) {
            input = input.substring(4);
        }

        List<String> numbers = new SeparatorManager(customSeparator).getSeparatedStringNumber(input);

        System.out.println("결과 : " + StringCalculator.calculate(numbers));
    }
}
