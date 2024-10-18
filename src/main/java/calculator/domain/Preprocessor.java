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
    // 클래스 전체에서 사용 가능하므로 불변성을 유지하는게 좋다고 판단
    private final String input;

    public Preprocessor(String input) {
        this.input = input == null ? "" : input;
    }

    public PreprocessedInput preprocess() {
        if (input.startsWith(DELIMITER_PREFIX)) {
            return extractDelimiterWithMatcher();
        }
        return new PreprocessedInput(input, DELIMITERS);
    }

    private PreprocessedInput extractDelimiterWithMatcher() {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX_PATTERN).matcher(input);
        if (matcher.find()) {
            ArrayList<Character> newDelimiters = new ArrayList<>(DELIMITERS);
            newDelimiters.add(matcher.group(1).charAt(0));
            return new PreprocessedInput(matcher.group(2), newDelimiters);
        }
        throw new IllegalArgumentException();
    }
}
