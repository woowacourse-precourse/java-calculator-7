package calculator.presentation.parser;

import calculator.presentation.request.CalculatorRequest;

public class RegexInputParser implements InputParser {

    private static final String PREFIX_REGEX = "//";
    private static final String SUFFIX_REGEX = "\\\\n";

    // json도 파싱하듯이, 우리만의 파싱 역할이 따로 있음
    public CalculatorRequest parseToRequest(String input) {
        String[] splitInput = input.split(SUFFIX_REGEX);

        if (splitInput.length == 1) {
            return new CalculatorRequest(splitInput[0], null);
        } else {
            String tokens = splitInput[1];
            String customDelimiter = parseToCustomDelimiter(splitInput[0]);

            return new CalculatorRequest(tokens, customDelimiter);
        }
    }

    private String parseToCustomDelimiter(String input) {
        if (!input.startsWith(PREFIX_REGEX)) {
            throw new IllegalArgumentException();
        }
        return input.substring(2);
    }
}
