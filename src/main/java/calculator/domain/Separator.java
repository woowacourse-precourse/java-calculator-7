package calculator.domain;

import calculator.constant.Constant;
import calculator.util.RegexGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public List<String> separateByDelimiter(String input, String delimiter) {
        String delimiterRegex = RegexGenerator.generateRegex(delimiter);
        return Arrays.asList(input.split(delimiterRegex));
    }

    public String separateToFormulaPart(String input) {
        if (input.startsWith(Constant.CUSTOM_DELIMITER_PREFIX)) {
            Matcher matcher = Pattern.compile(Constant.VALIDATION_REGEX).matcher(input);
            validateFormat(matcher);

            return input.split(Constant.CUSTOM_DELIMITER_SUFFIX)[1];
        }

        return input;
    }

    private void validateFormat(Matcher matcher) {
        if (matcher.results().count() != 1) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }
}