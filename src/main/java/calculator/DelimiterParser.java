package calculator;

public class DelimiterParser {

    public String[] parseFromInput(String input) {
        String modifiedInput = changeDelimiter(input);
        return modifiedInput.split(",");
    }

    private String changeDelimiter(String input) {
        StringBuilder result = new StringBuilder();
        Delimiters delimiters = new Delimiters();
        String originalInput = input;

        if (input.startsWith("//") && input.contains("\n")) {
            String[] splitInput = input.substring("//".length()).split("\n");

            String newDelimiter = splitInput[0];
            delimiters.add(newDelimiter);
            originalInput = splitInput[1];
        }

        for (char element : originalInput.toCharArray()) {
            if (delimiters.isDelimiter(String.valueOf(element))) {
                result.append(',');
                continue;
            }
            result.append(element);
        }
        return result.toString();
    }
}
