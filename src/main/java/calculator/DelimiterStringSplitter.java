package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record DelimiterStringSplitter(
        String targetString,
        String[] delimiters
) {
    public static DelimiterStringSplitter extractDelimiterAndTargetString(String input) {

        Pattern defaultPattern = Pattern.compile("^(\\d*(,\\d+)*(:\\d+)*)*");
        Matcher defaultMatcher = defaultPattern.matcher(input);

        Pattern customPattern = Pattern.compile("^/{2}(\\D+)\\\\n(.*)");
        Matcher customMatcher = customPattern.matcher(input);

        String[] delimiter;
        String targetString;

        if (defaultMatcher.matches()) {
            delimiter = new String[]{",", ":"};
            targetString = input;
        } else if (customMatcher.matches()) {
            delimiter = new String[]{customMatcher.group(1)};
            targetString = customMatcher.group(2);
        } else {
            throw new IllegalArgumentException("입력하신 문자열이 프로그램에서 제공하는 구분자가 아닙니다.");
        }

        return new DelimiterStringSplitter(targetString, delimiter);
    }

    public List<Integer> splitTargetStringToNumArray() {
        String regex = String.join("|", delimiters);
        if ("".equals(targetString)) {
            return new ArrayList<>();
        }
        return Arrays.stream(targetString.split(regex))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

}
