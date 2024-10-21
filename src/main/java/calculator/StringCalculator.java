package calculator;

import java.util.Arrays;

public class StringCalculator{

    private DelimiterManager delimiterManager;
    private InputValidator inputValidator;
    private StringSplitter stringSplitter;

    public StringCalculator() {
        this.delimiterManager = new DelimiterManager();
        this.inputValidator = new InputValidator(delimiterManager);
        this.stringSplitter = new StringSplitter(delimiterManager);
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        input = delimiterManager.addCustomDelimiter(input);
        inputValidator.validateInput(input);

        // 입력 문자열을 구분자로 분리
        String[] numbers = stringSplitter.splitInput(input);

        // 문자열에 포함된 양수 합 계산
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
