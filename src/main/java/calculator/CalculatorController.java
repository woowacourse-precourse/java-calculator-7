package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CalculatorController {

    private final static String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final static String RESULT_MESSAGE = "결과 : ";

    private final CustomDelimiterValidator customDelimiterValidator;
    private final DelimiterExtractor delimiterExtractor;
    private final NumberExtractor numberExtractor;
    private final SumCalculator sumCalculator;

    public CalculatorController() {
        this.customDelimiterValidator = new CustomDelimiterValidator();
        this.delimiterExtractor = new DelimiterExtractor();
        this.numberExtractor = new NumberExtractor();
        this.sumCalculator = new SumCalculator();
    }

    public void run() {
        String input = getInput();

        customDelimiterValidator.validate(input);
        List<String> delimiters = delimiterExtractor.extract(input);
        List<Integer> numbers = numberExtractor.extract(input,delimiters);
        int result = sumCalculator.calculate(numbers);

        getResult(result);
    }

    private String getInput() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    private void getResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

}
