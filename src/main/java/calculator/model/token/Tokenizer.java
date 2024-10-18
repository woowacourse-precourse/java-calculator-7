package calculator.model.token;

public class Tokenizer {

    private CustomDelimiterToken customDelimiterToken;
    private NumbersToken numbersToken;

    public CustomDelimiterToken createCustomDelimiterToken(String input) {
        customDelimiterToken = new CustomDelimiterToken(splitCustomDelimiterToken(input));
        return customDelimiterToken;
    }

    public NumbersToken createNumbersToken(String input) {
        numbersToken = new NumbersToken(splitNumbersToken(input));
        return numbersToken;
    }

    public boolean isExistsCustomDelimiterToken(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    private String splitCustomDelimiterToken(String input) {
        return input.split("\\\\n")[0];
    }

    private String splitNumbersToken(String input) {
        String[] split = input.split("\\\\n", -1);

        if (isExistsCustomDelimiterToken(input)) {
            return split[1];
        }

        return input;
    }
}
