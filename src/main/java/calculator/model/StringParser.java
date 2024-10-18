package calculator.model;


import java.util.Arrays;
import java.util.List;

public class StringParser {

    private final static String DELIMITER_SEPERATOR = "|";
    private final static String CUSTOM_CREATOR_BACK = "\\n";

    private final DelimiterStore delimiterStore;

    public StringParser(DelimiterStore delimiterStore) {
        this.delimiterStore = delimiterStore;
    }

    public String splitTarget(String value) {
        return value.substring(value.lastIndexOf(CUSTOM_CREATOR_BACK) + CUSTOM_CREATOR_BACK.length());
    }

    public List<Integer> parseToNumbers(String value) {
        String[] numbers = value.split(getAllSpliterator());
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    private String getAllSpliterator() {
        List<String> delimiters = delimiterStore.getAllDelimiters();
        return String.join(DELIMITER_SEPERATOR, delimiters);
    }
}
