package calculator.number;

public class CustomPatternMaker {

    public static String getCustomPattern(String input) {
        StringBuilder customPattern = new StringBuilder();
        String customSeparator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
        String[] customSeparators = customSeparator.split("");
        for (String separator : customSeparators) {
            customPattern.append("\\").append(separator).append("|");
        }
        return customPattern.toString();
    }
}
