package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringServiceImpl implements StringService {
    @Override
    public List<String> parse(String input) {
        String delimiter = ",|:";
        boolean isCustom = input.startsWith("//");
        if (isCustom) {
            Matcher matcher = Pattern.compile("//(.+)\\\\n(.*)").matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);
                String customDelimiterQuote = Pattern.quote(customDelimiter);
                delimiter = delimiter + "|" + customDelimiterQuote;
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("알맞은 입력 형식이 아닙니다.");
            }
        }
        String inputRegex = ("^\\d+((" + delimiter + ")(\\d+))*");
        Matcher inputMatcher = Pattern.compile(inputRegex).matcher(input);

        if (input.isEmpty()) {
            return new ArrayList<>();
        }
        if (!inputMatcher.matches()) {
            throw new IllegalArgumentException("알맞은 입력 형식이 아닙니다.");
        }
        return Arrays.asList(input.split(delimiter));
    }

    @Override
    public List<Integer> toIntegerList(List<String> stringList) {
        return stringList.stream().map(Integer::parseInt).toList();
    }
}
