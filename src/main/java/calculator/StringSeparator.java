package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private final ValidChecker validChecker = new ValidChecker();

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");      // 정규 표현식을 통해 커스텀 구분자의 길이가 1을 넘을 수 없음

    public String[] parseNumbers(String input) {
        validChecker.emptyStringCheck(input);

        if (input.startsWith("//")) {
            return parseWithCustomDelimiter(input);
        }

        String[] splitStrings = input.split(DEFAULT_DELIMITER);
        validChecker.numberCheck(splitStrings);     // 숫자가 아닌 문자 확인
        validChecker.delimiterCheck(splitStrings);  // 맨 끝에 구분자 혹은 구분자가 연속해서 두 개인 경우 (비어있는 문자열이 분리된 문자열에 포함되어 있음)
        validChecker.lastCharCheck(input, DEFAULT_DELIMITER);

        return Arrays.stream(splitStrings)
                .map(String::trim)
                .toArray(String[]::new);
    }

    private String[] parseWithCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {      // 잘못된 커스텀 구분자 형식 처리
            throw new IllegalArgumentException();
        }

        String delimiter = matcher.group(1);
        validChecker.customDelimiterNumCheck(delimiter);

        String numbers = matcher.group(2);

        String allDelimiter = String.format("%s|%s", DEFAULT_DELIMITER, delimiter);
        System.out.println(allDelimiter);
        if ("-".equals(delimiter) && numbers.contains("-")) {    // 커스텀 구분자가 '-'이면 음수 불가능
            throw new IllegalArgumentException();
        }

        String[] splitStrings = numbers.split(allDelimiter);
        validChecker.numberCheck(splitStrings);     // 숫자가 아닌 문자 확인
        validChecker.delimiterCheck(splitStrings);  // 맨 끝에 구분자 혹은 구분자가 연속해서 두 개인 경우 (비어있는 문자열이 분리된 문자열에 포함되어 있음)
        validChecker.lastCharCheck(input, allDelimiter);
        return splitStrings;
    }
}
