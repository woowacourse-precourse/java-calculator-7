package calculator.model;

import static calculator.model.Delimiters.createDelimiters;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandler {
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(\\D)\\\\n.*");
    private static final String NUMBER_PATTERN = "[1-9][0-9]*";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\\\n";

    private String input;
    private Delimiters delimiters;

    private StringHandler(final String input) {
        this.input = input;
    }

    public static StringHandler createStringHandler(final String input) {
        return new StringHandler(input);
    }

    public void extractDelimiter() {
        Matcher matcher = DELIMITER_PATTERN.matcher(input);
        String[] splitDelimiter = input.split(CUSTOM_DELIMITER_END);

        if (splitDelimiter[0].startsWith(CUSTOM_DELIMITER_START)) {
            validateDelimiter(matcher);
            input = splitDelimiter[1];
            this.delimiters = createDelimiters(matcher.group(1).charAt(0));
            return;
        }
        input = splitDelimiter[0];
        this.delimiters = createDelimiters();
    }

    private void validateDelimiter(Matcher matcher) {
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 구분자 형식입니다");
        }
    }

    public Numbers extractNumbers() {
        String delimitersRegex = delimiters.getRegex();
        Pattern INPUT_PATTERN = Pattern.compile("(" + NUMBER_PATTERN + delimitersRegex + ")*" + NUMBER_PATTERN);
        Matcher matcher = INPUT_PATTERN.matcher(input);

        validateNumbers(matcher);
        return Numbers.createNumbers(Arrays.stream(input.split(delimitersRegex)).toList());
    }

    private void validateNumbers(Matcher matcher) {
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 형식입니다");
        }
    }
}
