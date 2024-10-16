package calculator.service;

import calculator.constant.ValidConstants;
import calculator.model.Separator;
import calculator.validator.InputValid;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitService {
    private static SplitService instance;

    private SplitService() {
    }

    public static SplitService getInstance() {
        if (instance == null) {
            instance = new SplitService();
        }
        return instance;
    }

    public List<String> splitNumber(Separator sep, String numbersStr) {
        // 구분자들을 정규표현식 OR(|)로 연결
        String regex = sep.getSeparators().stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        // 문자열을 구분자로 나누기
        String[] numbers = numbersStr.split(regex);

        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())
                .map(InputValid::checkNumber)
                .collect(Collectors.toList());
    }

    public String[] extractCustomSeparatorAndNumbers(String input) {
        Matcher matcher = ValidConstants.CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return new String[]{matcher.group(1), matcher.group(2)};
        }
        return new String[]{"", input};
    }

}
