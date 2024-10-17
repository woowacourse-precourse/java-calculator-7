package calculator;

public class StringPreprocessor {

    public String removeDelimiterPart(String input) {
        System.out.println("input = " + input);
        if (input == null || input.isEmpty()) {
            return "0";
        }

        if (input.startsWith("//") && input.contains("\\n")) {
            int endIndex = input.indexOf("\\n");
            return input.substring(endIndex + 2);
        }
        return input;
    }
}