package calculator;

public class Calculator {
    private final static String BASIC_SEPARATOR = ":,";

    public Integer calculate(String input) {
        int rtn = 0;
        if (input.length() == 0) {
            return rtn;
        }
        ExpressionDto expressionDto = getDelimiter(input);
        String delimiter = expressionDto.getDelimiter();
        input = expressionDto.getInput();
        String[] stringNumbers = input.split(delimiter);
        for (int i = 0; i < stringNumbers.length; i++) {
            rtn += parseInt(stringNumbers[i]);
        }
        return rtn;
    }

    private int parseInt(String stringNumber) {
        try {
            int value = Integer.parseInt(stringNumber);
            if (value < 0) {
                throw new IllegalArgumentException("음수부호가 입력되었습니다. : " + stringNumber);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("허용되지 않은 구분자가 들어있습니다. : " + stringNumber);
        }
    }

    private ExpressionDto getDelimiter(String input) {
        String rtnFormat = "[" + BASIC_SEPARATOR + "%s]";
        String delimiter;

        if (input.startsWith("//")) {
            char customDelimiter = input.charAt(2);
            delimiter = String.format(rtnFormat, customDelimiter);
            int delimiterIndex = input.indexOf("\\n") + 2;
            input = input.substring(delimiterIndex);
        } else {
            delimiter = String.format(rtnFormat, "");
        }
        return new ExpressionDto(input, delimiter);
    }
}
