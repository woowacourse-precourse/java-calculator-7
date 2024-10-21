package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class AddCalculatorProcess {

    private static String input;
    private static DelimiterExtractor delimiterExtractor;
    private static NumberExtractor numberExtractor;
    private static Double output;

    public static void start() {
        requestInput();
        initExtractor();
        validateExtractor();
        calculate();
    }

    private static void initExtractor() {
        delimiterExtractor = new DelimiterExtractor(input);
        numberExtractor = new NumberExtractor(StringParser.parseOperationFormula(input));
    }

    private static void calculate() {
        String regex = delimiterExtractor.createRegularExpression();

        List<Double> numbers = numberExtractor.extract(regex);
        AddCalculator.add(numbers);

        output = AddCalculator.sum();
    }

    private static void validateExtractor() {
        validateDelimiterExtractor();
        validateNumberExtractor();
    }

    private static void validateNumberExtractor() {
        String regex = delimiterExtractor.createRegularExpression();
        numberExtractor.validate(regex);
    }

    private static void validateDelimiterExtractor() {
        delimiterExtractor.validate();
    }

    private static void requestInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = StringParser.parseBr(Console.readLine());
        System.out.println(input);
    }

    public static void result() {
        System.out.println("결과 : " + Math.round(output));
    }
}
