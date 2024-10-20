package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.calculateStrategy.EmptyStringCalculateStrategy;
import calculator.calculateStrategy.IntegerCalculateStrategy;
import calculator.delimiterStrategy.CustomDelimiterStrategy;
import calculator.delimiterStrategy.DefaultDelimiterStrategy;
import calculator.numberStrategy.SimpleNumberStrategy;

public class Application {
    private static final String inputPhrase = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputPhrase = "결과 : ";
    private static final String startCustomPattern = "//";
    private static final String endCustomPattern = "\n";
    private static StringCalculator stringCalculator;

    public static void main(String[] args) {
        System.out.println(inputPhrase);
        String userInput = readLine();
        userInput = userInput.replace("\\n", "\n");

        stringCalculator = new StringCalculator(userInput);
        stringCalculator.setNumberStrategy(new SimpleNumberStrategy());
        configureDelimiterStrategy(userInput);
        configureCalculateStrategy(userInput);
        
        try {
            System.out.println(outputPhrase + stringCalculator.operate());
        } catch (IllegalArgumentException e) {
        }
    }

    private static boolean isCustomDelimiter(String userInput) {
        return userInput.startsWith(startCustomPattern) && userInput.contains(endCustomPattern);
    }

    private static void configureDelimiterStrategy(String userInput) {
        if (isCustomDelimiter(userInput)) {
            stringCalculator.setDelimiterStrategy(new CustomDelimiterStrategy());
        } else {
            stringCalculator.setDelimiterStrategy(new DefaultDelimiterStrategy());
        }
    }

    private static void configureCalculateStrategy(String userInput) {
        if (userInput.isEmpty()) {
            stringCalculator.setCalculate(new EmptyStringCalculateStrategy());
        } else {
            stringCalculator.setCalculate(new IntegerCalculateStrategy());
        }
    }
}
