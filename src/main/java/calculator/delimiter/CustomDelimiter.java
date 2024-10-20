package calculator.delimiter;

import calculator.exception.CalculatorException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter extends Delimiter {

    private static final String REGEX = "//(.*?)(\\\\n)";
    private static final String REGEX2 = "(" + REGEX + ")";
    private static final String DOUBLE_SLASH = "//";
    private static final String NEW_LINE = "\\n";

    private Pattern pattern = Pattern.compile(REGEX);

    public CustomDelimiter() {
        super();
    }

    @Override
    public boolean hasCustomDelimiter(String s) {
        return s.contains(DOUBLE_SLASH) && s.contains(NEW_LINE);
    }

    @Override
    protected String addDelimiter(String s) {
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String group = matcher.group(1);

            if (!isNull(s)) {
                validateDelimiterRight(group);
                delimiters.add(group);
                s = removeCustomDelimiter(s);
            }

        }

        return s;
    }

    @Override
    public List<String> divideCharacter(String s) {

        if (hasCustomDelimiter(s)) {
            s = addDelimiter(s);
        }

        List<String> result = divideByDelimiter(s);

        if (!areDigits(result)) {
            CalculatorException.causeException("잘못된 문자가 들어있습니다.");
        }

        return result;
    }

    @Override
    protected List<String> divideByDelimiter(String s) {
        return Arrays.stream(s.split(makeRegexByDelimiter()))
                .map(this::isZeroThenThrow)
                .toList();
    }

    private String makeRegexByDelimiter() {
        return String.join("|", delimiters);
    }

    private void validateDelimiterRight(String delimiter) {
        if (hasCustomDelimiter(delimiter) || delimiter.isEmpty()) {
            CalculatorException.causeException("잘못된 커스텀 구분자입니다.");
        }
    }

    private String removeCustomDelimiter(String s) {
        Matcher matcher = Pattern.compile(REGEX2).matcher(s);

        if (matcher.find()) {
            s = s.replace(matcher.group(1), "");
        }
        return s;
    }

    private boolean isNull(String s) {
        return s == null;
    }
}
