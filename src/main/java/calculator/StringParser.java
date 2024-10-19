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

    public int getDelimiterCount() {
        return delimiters.size();
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

    private String getPattern() {
        StringBuilder sb = new StringBuilder();

        sb.append(prefix);
        sb.append("(.*)");
        sb.append(suffix);
        sb.append("(.*)");

        return sb.toString();
    }

    private String getDelimiters() {
        StringBuilder sb = new StringBuilder();

        for (String delimiter : delimiters) {
            sb.append(delimiter);
            sb.append("|");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public List<String> split(String input) {
        if (input.startsWith(prefix)) {
            return List.of(input.split(suffix)[1].split(getDelimiters()));
        }

        return List.of(input.split(getDelimiters()));
    }

    public int[] convertToIntArray(List<String> strings) {
        return strings.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
