package calculator.domain;

import calculator.domain.model.PreprocessedInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preprocessor {
    /**
     * (.) : 임이의 한 문자 캡쳐
     * (.*) : .: 임의의 *: 여러 문자
     */
    private static final String CUSTOM_REGEX_PATTERN = "//(.)\\\\n(.*)";
    private static final String DELIMITER_PREFIX = "//";
    private static final ArrayList<Character> DELIMITERS = new ArrayList<>(Arrays.asList(',', ':'));
    // TODO: 여기가 final일 경우 코드가 좀 더 더러워 지는데, 여기가 final이 아니면 어떤 문제가 생길지 생각해보기
    private String input;

    public Preprocessor(String input) {
        this.input = input == null ? "" : input;
    }

    public PreprocessedInput preprocess() {
        if (input.startsWith(DELIMITER_PREFIX)) {
            extractDelimiterWithMatcher();
        }

        return new PreprocessedInput(input, DELIMITERS);
    }

    private void extractDelimiterWithMatcher() {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX_PATTERN).matcher(input);

        if (matcher.find()) {
            DELIMITERS.add(matcher.group(1).charAt(0));
            input = matcher.group(2);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
