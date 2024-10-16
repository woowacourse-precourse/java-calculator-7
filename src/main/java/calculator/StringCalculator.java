package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private String[] splitWithDefaultDelimiter(String input) {
        return input.split("[,:]");
    }

    private String[] splitWithCustomDelimiter(String input) {
        List<String> delimiters = new ArrayList<>();

        input = extractCustomDelimiter(input, delimiters);

        String delimiterRegex = String.join("|", delimiters);
        return input.split(delimiterRegex);
    }

    /*
    parameter : `input` - 사용자 입력
                `delimiters` - 커스텀 구분자를 저장할 리스트
    return : `input` - 앞 부분의 커스텀 구분자 정의를 제외한 사용자 입력
     */
    private String extractCustomDelimiter(String input, List<String> delimiters) {
        Pattern pattern = Pattern.compile("//(.)\n");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String delimiter = matcher.group(1);
            delimiters.add(Pattern.quote(delimiter));
            input = input.substring(matcher.end());
        }

        return input;
    }
}
