package calculator.domain.input;

import calculator.util.InputValidator;
import calculator.util.StringUtil;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterInput extends Input {

    private static final String REGEX = "//(.)\\\\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final int FIRST = 1;
    private static final int SECOND = 2;

    private final Matcher matcher = getMatcher();

    private CustomDelimiterInput(String text) {
        super(text);
    }

    public static Input from(String text) {
        return new CustomDelimiterInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        checkCustomFormat();

        return Arrays.stream(StringUtil.splitText(findString(), findCustom()))
                .map(InputValidator::validateOnlyPlainNumber)
                .peek(InputValidator::validatePositive)
                .toArray(Long[]::new);
    }

    private Matcher getMatcher() {
        return PATTERN.matcher(text);
    }

    private void checkCustomFormat() {
        InputValidator.validateCustomFormat(matcher);
    }

    private String findString() {
        return matcher.group(SECOND);
    }

    private String findCustom() {
        return matcher.group(FIRST);
    }

}
