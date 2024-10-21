package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    String SEPARATOR = "[,:]";
    String input;

    Parser(String input) {
        this.input = input.replace("\\n", "\n");
    }

    String findCustomSeparator() {
        Pattern pat = Pattern.compile("//(.+?)\n");
        Matcher matcher = pat.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    void removeCustomSeparator() {
        Pattern pat = Pattern.compile("//(.+?)\n");
        Matcher matcher = pat.matcher(input);
        this.input = matcher.replaceAll("");
    }

    String[] split() {
        String customSeparator = findCustomSeparator();
        removeCustomSeparator();
        this.input = input.replace(customSeparator, ",");
        return Pattern.compile(SEPARATOR).split(this.input);
    }

}
