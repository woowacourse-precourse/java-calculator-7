package calculator;

public class Delimiter {

    public String findDelimiter(String input) {
        String delimiters = ",|:";

        if (input.contains("//") && input.contains("\\n")) {
            int startIndex = input.indexOf("//") + 1;
            int endIndex = input.indexOf("\\n");
            String customDelimiters = input.substring(startIndex + 1, endIndex);
            delimiters += "|" + customDelimiters;
        }

        return delimiters;
    }
}