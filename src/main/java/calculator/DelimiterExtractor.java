package calculator;

public class DelimiterExtractor {

    public DelimiterNumberHandler extract(Input input) {
        if (input.hasCustomDelimiter()) {
            return extractCustomDelimiter(input);
        }
        return new DelimiterNumberHandler(Delimiter.defaultDelimiter().getDelimiters(), input.getInput());
    }

    private DelimiterNumberHandler extractCustomDelimiter(Input input) {
        String rawInput = input.getInput();
        int delimiterEndIndex = rawInput.indexOf(DelimiterConfig.CUSTOM_DELIMITER_SUFFIX);
        if (delimiterEndIndex == DelimiterConfig.DELIMITER_SUFFIX_INDEX) {
            String customDelimiter = rawInput.substring(DelimiterConfig.CUSTOM_DELIMITER_START_INDEX, delimiterEndIndex);
            String numbersString = rawInput.substring(delimiterEndIndex + DelimiterConfig.CUSTOM_DELIMITER_START_INDEX);
            String delimiters = Delimiter.customDelimiter(customDelimiter).getDelimiters();
            return new DelimiterNumberHandler(delimiters, numbersString);
        }
        throw new IllegalArgumentException("잘못된 커스텀 구분자 입력입니다");
    }
}
