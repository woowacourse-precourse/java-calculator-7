package calculator;

public class SplitString {
    public String[] splitInput(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException();
            }
            String customDelimiter = input.substring(2, delimiterIndex);
            delimiter += "|" + customDelimiter;
            input = input.substring(delimiterIndex + 2);
        }
        return input.split(delimiter);
    }
}
