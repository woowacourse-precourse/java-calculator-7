package calculator.handler;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterHandler {

    public List<Integer> split(String str) {
        String delimiter = extractDelimiter(str);

        String left = str.substring(str.indexOf("\n") + 1); // \n 이후 문자열을 가져옴

        return Arrays.stream(left.split(Pattern.quote(delimiter)))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String extractDelimiter(String s) {
        Pattern pattern = Pattern.compile("//(.*?)\\n");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) return matcher.group(1);
        return "";
    }
}
