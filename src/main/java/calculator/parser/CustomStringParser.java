package calculator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CustomStringParser implements StringParser{
    private static final String BASIC_DELIMITER_REGEX= "[,|:]"; // 기본 구분자 ,와 :
    private String customDelimiter;
    public void parseDelimiter(String input){
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            customDelimiter = input.substring(2, delimiterEndIndex);
        }
    }

    @Override
    public List<String> parse(String input) {
        parseDelimiter(input);
        String str = input.startsWith("//") ? input.split("\n", 2)[1] : input;

        String customRegex = customDelimiter != null
                ? BASIC_DELIMITER_REGEX + "|" + Pattern.quote(customDelimiter)
                : BASIC_DELIMITER_REGEX;

        return Arrays.stream(str.split(customRegex)).toList();
    }
}