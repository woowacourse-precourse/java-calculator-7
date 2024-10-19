package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterParser {
    public List<Character> parseDelimiter(String userInput) {
        List<Character> delimiter = new ArrayList<>();

        addBasicDelimiter(delimiter);
        addSpecialDelimiter(delimiter, userInput);

        return delimiter;
    }

    private void addSpecialDelimiter(List<Character> delimiter, String userInput) {
        StringBuilder delimiterBuilder = new StringBuilder(userInput);
        int start = delimiterBuilder.indexOf("//");
        int end = delimiterBuilder.indexOf("\n");

        if(end - start == 3){
            delimiter.add(delimiterBuilder.charAt(end-1));
        }else{
            throw new IllegalArgumentException("커스텀 구분자는 문자열이 아닌 문자여야 합니다.");
        }
    }

    private void addBasicDelimiter(List<Character> delimiter) {
        delimiter.add(',');
        delimiter.add(':');
    }

    public String parseMarker(String userInput) {
        StringBuilder delimiterBuilder = new StringBuilder(userInput);
        int start = delimiterBuilder.indexOf("//");
        int end = delimiterBuilder.indexOf("\n");

        String parsedUserInput = delimiterBuilder.substring(0,start) + delimiterBuilder.substring(end+1);

        return parsedUserInput;
    }
}
