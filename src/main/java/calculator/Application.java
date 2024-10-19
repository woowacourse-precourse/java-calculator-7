package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.NumberStrategy.SimpleNumberStrategy;
import calculator.calculateStrategy.emptyStringCalculate;
import calculator.calculateStrategy.integerCalculate;
import calculator.delimiterStrategy.CustomDelimiterStrategy;
import calculator.delimiterStrategy.DefaultDelimiterStrategy;

public class Application {
    private static final String inputPhrase = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputPhrase = "결과 : ";
    private static final String startCustomPattern = "//";
    private static final String endCustomPattern = "\n";
    private static StringCalculator stringCalculator;

    public static void main(String[] args) {
        System.out.println(inputPhrase);
        String userInput = readLine();
        stringCalculator = new StringCalculator(userInput);

        stringCalculator.setNumberStrategy(new SimpleNumberStrategy());
        configureDelimiterStrategy(userInput);
        configureCalculateStrategy(userInput);

        System.out.println(outputPhrase + stringCalculator.operate());
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
            stringCalculator.setCalculate(new emptyStringCalculate());
        } else {
            stringCalculator.setCalculate(new integerCalculate());
        }
    }
}
