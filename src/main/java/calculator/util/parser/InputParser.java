package calculator.util.parser;

import calculator.dto.DelimiterAndDataDto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITERS_PATTERN = "^\\d+([,:]\\d+)*$";
    private static final String CUSTOM_DELIMITERS_PATTERN = "^//(.+)\n(\\d+\\1)*\\d+$";
    private InputParser() {

    }

    public static List<Long> extractNumbers(final String input) {
        List<Long> numbers = new ArrayList<>();
        final DelimiterAndDataDto delimiterAndRawData = getDelimiterAndRawData(input);
        final String[] tokens = delimiterAndRawData.rawData()
                .split(delimiterAndRawData.delimiter());

        for (String token : tokens) {
            long number = parseToLong(token);
            numbers.add(number);
        }
        return numbers;
    }

    public static DelimiterAndDataDto getDelimiterAndRawData(final String input) {
        // TODO : 패턴(숫자,숫자 || //(커스텀)\n숫자(커스텀) 일치하는지 확인하고 하지 않으면 IllegalArgument 에러 발생시키기
        final Matcher defaultDelimiterMatcher = Pattern.compile(DEFAULT_DELIMITERS_PATTERN).matcher(input);
        final Matcher customDelimiterMatcher = Pattern.compile(CUSTOM_DELIMITERS_PATTERN).matcher(input);

        if (defaultDelimiterMatcher.matches()) {
            return DelimiterAndDataDto.of(",|:", input);
        }

        if (customDelimiterMatcher.matches()) {
            final String data = input.substring(4); // "//(custom delimiter)\n : 5글자
            return DelimiterAndDataDto.of(customDelimiterMatcher.group(1), data);
        }

        throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
    private static long parseToLong(String rawData) {
        try {
            return Long.parseLong(rawData.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }
}
