package calculator;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    public static List<String> splitByDelimiter(String userInput) {
        String delimiter = "[,:]";
        String content = userInput;

        Pattern pattern = Pattern.compile("//(.*)\\\\n(.*)");
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiter = Pattern.quote(customDelimiter);
            content = matcher.group(2);
        }

        return Arrays.asList(content.split(delimiter));
    }
}
