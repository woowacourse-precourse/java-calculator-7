package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCustomDelimiterPos {
    private CheckCustomDelimiterPos() {}

    public static void validate(String input) {
        String delimiter = "";
        Pattern pattern = Pattern.compile("//(.+)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            delimiter = matcher.group(1);
        }

        if(!delimiter.equals("") && !input.substring(0, 5).equals("//" + delimiter + "\\n")) {
            throw new IllegalArgumentException();
        }
    }
}
