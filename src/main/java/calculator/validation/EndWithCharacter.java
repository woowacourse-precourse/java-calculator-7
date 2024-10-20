package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EndWithCharacter {
    private EndWithCharacter() {};

    public static void validate(String input) {
        Pattern pattern = Pattern.compile(".*[^0-9]$");
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
