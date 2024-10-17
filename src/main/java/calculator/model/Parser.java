package calculator.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public List<String> parseInput(String input) {
        if (input.startsWith("//")) {
            return parseCustomSeparator(input);
        }

        return parseBasicSeparator(input);
    }

    private List<String> parseBasicSeparator(String input) {
        List<String> splitString = List.of(input.split(",|:"));

        return splitString;
    }

    private List<String> parseCustomSeparator(String input) {
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(input);

        String customSeparator = "";
        if (matcher.find()) {
            customSeparator = matcher.group(1);
        }
        String realInput = input.substring(input.lastIndexOf("\\n") + 2);

        return parseCustom(realInput, customSeparator);
    }

    public List<String> parseCustom(String input, String custom) {
        String separator = String.format(",|:|%s", custom);
        List<String> splitString = List.of(input.split(separator));

        return splitString;
    }

}
