package calculator.domain;

import calculator.util.InputValidator;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomInput extends Input {

    private static final String REGEX = "\\//(.)\\\\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final int FIRST = 1;
    private static final int SECOND = 2;

    private final String text;

    private CustomInput(String text) {
        this.text = text;
    }

    public static Input from(String text) {
        return new CustomInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        Matcher matcher = getMatcher();

        InputValidator.validateCustomFormat(matcher);

        String[] strings = findString(matcher)
                .split(findCustom(matcher));

        return Arrays.stream(strings)
                .map(Long::valueOf)
                .toArray(Long[]::new);
    }

    private Matcher getMatcher() {
        return PATTERN.matcher(text);
    }

    private String findString(Matcher matcher) {
        return matcher.group(SECOND);
    }

    private String findCustom(Matcher matcher) {
        return matcher.group(FIRST);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CustomInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
