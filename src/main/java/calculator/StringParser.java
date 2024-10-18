package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public int[] parseString(String input) {
        input = extractDelimiter(input);

        StringBuilder builder = new StringBuilder("[");
        for (String delimeter : delimiters) {
            builder.append(delimeter);
        }
        builder.append("]");

        Pattern pattern = Pattern.compile(builder.toString());
        String[] tokens = input.split(pattern.toString());

        return Arrays.stream(tokens).map(this::validateToken)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String extractDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.+)\\\\n");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if (matcher.group(1).length() > 1) {
                throw new IllegalArgumentException("커스텀 구분자가 문자열입니다. 문자로 입력해 주세요.");
            }
            delimiters.add(matcher.group(1));
            input = input.replaceFirst(Pattern.quote(matcher.group()), "");
        }

        return input;
    }

    private String validateToken(String token) {
        if (!token.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("문자열에 구분자, 양수 외 문자가 포함되어 있습니다.");
        }
        return token;
    }
}
