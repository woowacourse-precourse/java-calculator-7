package calculator;

public class DelimiterExtractor {

    public String getDelimiter(String numbers) {
        String delimiter = ":|,";

        if (isCustomDelimiter(numbers)) {
            int delimiterEndIndex = getDelimiterEndIndex(numbers);
            if (delimiterEndIndex != -1) {
                delimiter = numbers.substring(2, delimiterEndIndex);
                return delimiter;
            }
        }
        return delimiter;
    }

    public boolean checkDelimiter(String delimiter) {
        return !delimiter.contains(":|,");
    }

    private boolean isCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    public int getDelimiterEndIndex(String numbers) {
        return numbers.indexOf("\\n");
    }

}
