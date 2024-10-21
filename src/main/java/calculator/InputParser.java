package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    private final InputValidator inputValidator;

    public InputParser(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public boolean isCustomDelimiterExisted(String input) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
        return matcher.matches();
    }

    public String[] parseCustomDelimiterInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String customDelimiter = matcher.group(1);
        String formula = matcher.group(2);
        inputValidator.validateCustomDelimiter(customDelimiter);

        // 커스텀 구분자가 "." 이나 "+" 일 경우
        if (customDelimiter.equals(".") || customDelimiter.equals("+")) {
            customDelimiter = Pattern.quote(customDelimiter);
        }

        String newDelimiter = DEFAULT_DELIMITER + "|" + customDelimiter;
        inputValidator.validateFormula(formula, newDelimiter);

        return formula.split(newDelimiter);
    }

    public String[] parseDefaultInput(String input) {

        inputValidator.validateFormula(input, DEFAULT_DELIMITER);
        return input.split(DEFAULT_DELIMITER);
    }
}
