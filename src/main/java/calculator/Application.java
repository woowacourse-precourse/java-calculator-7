package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        SeparatorExtractor extractor = new SeparatorExtractor();

        SeparatorExtractor.ExtractResult extracted = extractor.extract(input);
        String expression = extracted.getExpression();
        Optional<Character> separatorOptional = extracted.getSeparator();

        Calculator calculator;
        if (separatorOptional.isPresent()) {
            char separator = separatorOptional.get();
            calculator = new Calculator(expression, separator);
        } else {
            calculator = new Calculator(expression);
        }

        int sum = calculator.calculate();
        System.out.println("결과 : " + sum);
    }
}
