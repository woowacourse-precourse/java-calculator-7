package calculator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    public String[] parseDelimiters(String input) {
        String delimiter = ",|:";  //기본 구분자
        String numberPart = input;

        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            delimiter = Pattern.quote(matcher.group(1));
            numberPart = matcher.group(2);
        }

        return numberPart.split(delimiter);
    }//parseDelimiters
}//class
