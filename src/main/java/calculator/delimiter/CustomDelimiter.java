package calculator.delimiter;

import calculator.exception.CalculatorException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter extends Delimiter {

    private static final String REGEX = "//(.*?)(\\\\n)";

    private Pattern pattern = Pattern.compile(REGEX);

    public CustomDelimiter() {
        super();
    }

    @Override
    public boolean hasCustomDelimiter(String s) {
        return s.contains("//") && s.contains("\\n");
    }

    @Override
    protected void addDelimiter(String s) {
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group(1);

            if (group != null) {
                delimiters.add(group.trim());
            }

        }
    }

    @Override
    public List<String> divideCharacter(String s) {

        if (hasCustomDelimiter(s)) {
            addDelimiter(s);
            s = s.substring(s.lastIndexOf("\\n") + 2);
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
                .map(str -> str.isEmpty() ? "0" : str)
                .toList();
    }

    private String makeRegexByDelimiter() {
        return String.join("|", delimiters);
    }
}
