package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {
    private final List<Character> delimiters = new ArrayList<>();

    public Delimiters(){
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters(){
        delimiters.add(',');
        delimiters.add(':');
    }

    public List<Character> getDelimiters(){
        return delimiters;
    }

    public char findCustomDelimiter(String input) {
        String regex = "^//(.)\\\\n(.*)";
        char delimiter = ',';

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1).charAt(0);
        }
        return delimiter;
    }
}
