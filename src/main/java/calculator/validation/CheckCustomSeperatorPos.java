package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCustomSeperatorPos {
    private CheckCustomSeperatorPos() {};

    public static void validate(String input) {
        String seperator = "";
        Pattern pattern = Pattern.compile("//(.+)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            seperator = matcher.group(1);
        }

        if(!seperator.equals("") && !input.substring(0, 5).equals("//" + seperator + "\\n")) {
            throw new IllegalArgumentException();
        }
    }
}
