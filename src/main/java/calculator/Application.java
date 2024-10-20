package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringParser parser = new StringParser();
        StringValidator validator = new StringValidator();
        StringCalculator calculator = new StringCalculator();

        try {
            validator.validate(input);
            List<String> numbers = parser.parse(input);
            validator.validateNumbers(numbers);
            String result = calculator.add(numbers);
            System.out.println("결과 : " + result);
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
