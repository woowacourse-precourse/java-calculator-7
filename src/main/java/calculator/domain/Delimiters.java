package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {
    private final List<String> delimiters = new ArrayList<>();

    public Delimiters(){
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters(){
        delimiters.add(",");
        delimiters.add(":");
    }

    public List<String> getDelimiters(){
        return delimiters;
    }

    public String findCustomDelimiter(String input) {
        String regex = "^//(.*)\\\\n(.*)";
        String delimiter = null;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
        }
        return delimiter;
    }
}
