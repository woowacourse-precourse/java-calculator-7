package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartWithCharacter {
    private StartWithCharacter() {};

    public static void validate(String input) {
        Pattern pattern = Pattern.compile("^(?!//(.)\\\\n)(?!\\d).*");
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
