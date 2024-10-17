package calculator.calculate.util;

import calculator.calculate.exception.InvalidFormatException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateRequestParser {

    private static final String PARSING_REGEX_RULE = "^//(.)\\\\n(.*)?$";//"^//(.+?)\\n(.*)$";

    private static final Pattern PARSING_PATTERN = Pattern.compile(PARSING_REGEX_RULE);

    public static List<Integer> parsingRequest(final String parsingTarget, final List<String> defaultDelimiters)
            throws IllegalArgumentException {
        if (parsingTarget == null) {
            throw new InvalidFormatException("파싱할 객체가 존재하지 않습니다.");
        }
        if (parsingTarget.isEmpty()) return new ArrayList<>();

        // 안전성을 위해 깊은 복사
        ArrayList<String> delimiters = new ArrayList<>(defaultDelimiters);

        String numbersString;

        // 커스텀 생성자가 존재하는 경우
        if (parsingTarget.startsWith("//")) {
            Matcher matcher = PARSING_PATTERN.matcher(parsingTarget);
            if (!matcher.matches()) {
                throw new InvalidFormatException(String.format("%s는 규칙에 맞는 입력이 아닙니다.", parsingTarget));
            }

            delimiters.add(Pattern.quote(matcher.group(1)));
            numbersString = matcher.group(2);
        } else { // 커스텀 생성자가 존재하지 않는 경우
            numbersString = parsingTarget;
        }

        String concatenatedDelimiters = String.join("|", delimiters);

        return Arrays.stream(numbersString.split(concatenatedDelimiters, -1))
                .map(numberString -> {
                    try {
                        return Integer.parseInt(numberString);
                    } catch (NumberFormatException e) {
                        throw new InvalidFormatException(String.format("%s는 규칙에 맞는 입력이 아닙니다.", parsingTarget));
                    }
                })
                .toList();
    }
}
