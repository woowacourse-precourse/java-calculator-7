package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private List<String> delimiters = new ArrayList<>();
    private String firstDelimiter = ",";
    private String secondDelimiter = ":";

    private String prefix = "//";
    private String suffix = "\n";


    public StringParser() {
        delimiters.add(firstDelimiter);
        delimiters.add(secondDelimiter);
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    private String getPattern() {
        StringBuilder sb = new StringBuilder();

        sb.append(prefix);
        sb.append("(.*)");
        sb.append(suffix);
        sb.append("(.*)");

        return sb.toString();
    }

    public void addDelimiterFromInput(String input) {
        Matcher m = Pattern.compile(getPattern()).matcher(input);

        if (m.matches()) {
            String customDelimiter = m.group(1);

            if (customDelimiter.length() > 1) {
                throw new IllegalArgumentException();
            }

            delimiters.add(customDelimiter);
        }
    }
}
