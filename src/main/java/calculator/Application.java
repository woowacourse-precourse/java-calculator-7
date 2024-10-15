package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final List<String> DEFAULT_DELIMITERS = java.util.List.of(",", ":");
    private static final List<String> DELIMITERS = new ArrayList<>(DEFAULT_DELIMITERS);

    public static void main(String[] args) {
        String userInput = "//1\n2,3:4";

        CustomDelimiterCalculator customDelimiterCalculator = new CustomDelimiterCalculator();
        if (customDelimiterCalculator.hasCustomDelimiter(userInput)) {
            String customDelimiter = customDelimiterCalculator.extractCustomDelimiterFrom(userInput);
            DELIMITERS.add(customDelimiter);
            userInput = customDelimiterCalculator.removeCustomDelimiterPrefix(userInput);
        }

        System.out.println(userInput);
        System.out.println(DELIMITERS);
    }
}
