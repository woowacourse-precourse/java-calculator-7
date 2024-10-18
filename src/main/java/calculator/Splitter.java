package calculator;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    public static List<String> splitByDelimiter(String userInput) {
        String delimiter = "[,:]";

        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            userInput = matcher.group(2);
        }

        return Arrays.asList(userInput.split(delimiter));
    }
}
