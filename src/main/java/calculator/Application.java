package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        StringPreprocessor preprocessor = new StringPreprocessor();
        Delimiter delimiter = new Delimiter();
        NumberExtractor numberExtractor = new NumberExtractor();
        Calculator calculator = new Calculator();

        String numbersPart = preprocessor.removeDelimiterPart(input);
        String delimiters = delimiter.findDelimiter(input);

        List<Integer> numbers = numberExtractor.extractNumbers(numbersPart, delimiters);
        int result = calculator.calculate(numbers);

        System.out.println("결과 : " + result);
    }
}