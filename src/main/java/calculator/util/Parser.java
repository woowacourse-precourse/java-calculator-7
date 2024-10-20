package calculator.util;

import calculator.domain.Delimiter;
import calculator.domain.Number;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String parseCustomDelimiter(String input) {
        String result = null;

        String regex = "//(.)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            result = matcher.group(1);
        }

        return result != null ? result : "";
    }

    public static List<Number> parseNumber(String input, Delimiter delimiter) {
        input = input.replaceAll("//(.*)\n", "");
        return Arrays
            .stream(splitWithDelimiter(input, delimiter))
            .map(Number::new)
            .toList();
    }

    private static String[] splitWithDelimiter(String input, Delimiter delimiter) {
        return input.split("[" + String.join("", delimiter.getDelimiters()) + "]");
    }
}
