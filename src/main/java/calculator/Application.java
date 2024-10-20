package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final String DEFAULT_CUSTOM_DELIMITER_PREFIX = "//";
    private static final String DEFAULT_CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static void main(String[] args) {
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor(
                DEFAULT_CUSTOM_DELIMITER_PREFIX, DEFAULT_CUSTOM_DELIMITER_SUFFIX
        );
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        DelimiterResult result = customDelimiterExtractor.extractDelimiter(input);
        if (result.hasCustomDelimiter()) {
            delimiters.add(result.customDelimiter());
        }
        ExpressionParser expressionParser = new ExpressionParser(delimiters);

        Calculator calculator = new Calculator(expressionParser);
        int sum = calculator.calculateSum(result.expressionAfterDelimiter());
        System.out.println("결과 : " + sum);
    }
}
