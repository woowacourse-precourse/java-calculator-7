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
                throw new IllegalArgumentException("'//'에 매칭되는 '\\n' 이 있어야 합니다.");
            }
            if (delimiterEndIndex - delimiterStartIndex != 1) {
                throw new IllegalArgumentException("커스텀 구분자로는 길이가 1인 문자를 지정해야 합니다.");
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
