package calculator;

public class DelimiterParser {

    public String[] parseFromInput(String input) {
        String modifiedInput = changeDelimiter(input);
        return modifiedInput.split(",");
    }

    private String changeDelimiter(String input) {
        StringBuilder result = new StringBuilder();
        for (char element : input.toCharArray()) {
            if (isDelimiter(element)) {
                result.append(',');
                continue;
            }
            result.append(element);
        }
        return result.toString();
    }

    private boolean isDelimiter(char element) {
        if (element == ',' || element == ':') {
            return true;
        }
        return false;
    }
}
