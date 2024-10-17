package calculator;

import java.util.stream.Stream;

public class StringParser {
    public int[] parse(String input) {

        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiter = "[" + customDelimiter + "," + ":" + "]";
            String numbersStr = input.substring(delimiterEndIndex + 2);
            return Stream.of(numbersStr.split(delimiter)).mapToInt(Integer::parseInt).toArray();
        }
        return Stream.of(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }
}
