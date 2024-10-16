package calculator.delimiter.handler.impl;

import calculator.delimiter.handler.DelimiterHandler;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterHandler implements DelimiterHandler {

    @Override
    public List<String> split(String str) {
        String delimiter = extractDelimiter(str);

        String left = str.substring(str.indexOf("\n") + 1);

        return Arrays.stream(left.split(Pattern.quote(delimiter)))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isSupport(String str) {
        return str.startsWith("//") && str.contains("\n");
    }

    public String extractDelimiter(String s) {
        Pattern pattern = Pattern.compile("//(.*?)\\n");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) return matcher.group(1);
        return "";
    }
}
