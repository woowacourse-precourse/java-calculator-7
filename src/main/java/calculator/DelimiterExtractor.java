package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    public DelimiterExtractionResult extractDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.+)\\\\n");
        Matcher matcher = pattern.matcher(input);

        List<String> delimiters = new ArrayList<>();
        while (matcher.find()) {
            if (matcher.group(1).length() > 1) {
                throw new IllegalArgumentException("커스텀 구분자가 문자열입니다. 문자로 입력해 주세요.");
            }
            delimiters.add(matcher.group(1));
            input = input.replaceFirst(Pattern.quote(matcher.group()), "");
        }

        return new DelimiterExtractionResult(input, delimiters);
    }


}
