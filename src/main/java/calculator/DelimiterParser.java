package calculator;

public class DelimiterParser {
    public String parse(String numbers) {
        String delimiter = ":|,";
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                delimiter = numbers.substring(2, delimiterEndIndex);
                return delimiter;
            }
        }
        return delimiter;
    }
}
