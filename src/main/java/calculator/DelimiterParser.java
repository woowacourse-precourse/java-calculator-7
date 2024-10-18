package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterParser {
    private final List<Character> delimiters = new ArrayList<>();
    private String valueString;

    public void parseDelimiters(String inputString) {
        int currentIndex = 0;
        while (inputString.startsWith("//", currentIndex)) {
            int delimiterStartIndex = currentIndex + 2;
            int delimiterEndIndex = inputString.indexOf("\\n", delimiterStartIndex);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            if (delimiterEndIndex - delimiterStartIndex != 1) {
                throw new IllegalArgumentException();
            }
            delimiters.add(inputString.charAt(delimiterStartIndex));
            currentIndex = delimiterEndIndex + 2;
        }
        valueString = inputString.substring(currentIndex);
    }

    public List<Character> getDelimiters() {
        return delimiters;
    }

    public String getValueString() {
        return valueString;
    }
}
