package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.calculateStrategy.EmptyStringCalculateStrategy;
import calculator.calculateStrategy.IntegerCalculateStrategy;
import calculator.delimiterStrategy.CustomDelimiterStrategy;
import calculator.delimiterStrategy.DefaultDelimiterStrategy;
import calculator.numberStrategy.SimpleNumberStrategy;
import java.util.NoSuchElementException;

public class Application {
    private static final String inputPhrase = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputPhrase = "결과 : ";
    private static StringCalculator stringCalculator;

    public static void main(String[] args) {
        System.out.println(inputPhrase);
        String userInput;
        try {
            userInput = readLine();
            userInput = userInput.replace("\\n", "\n");

            stringCalculator = new StringCalculator(userInput);
            stringCalculator.setNumberStrategy(new SimpleNumberStrategy());
            stringCalculator.setCalculateStrategy(new IntegerCalculateStrategy());
            configureDelimiterStrategy(userInput);

            System.out.println(outputPhrase + stringCalculator.operate());
        } catch (NoSuchElementException e) {
            userInput = "";
            stringCalculator = new StringCalculator(userInput);
            stringCalculator.setCalculateStrategy(new EmptyStringCalculateStrategy());
            System.out.println(outputPhrase + stringCalculator.emptyStringOperate());
        }
    }

    private static boolean isCustomDelimiter(String userInput) {
        return userInput.startsWith(stringCalculator.getStartCustomPattern())
                && userInput.contains(stringCalculator.getEndCustomPattern());
    }

    private static void configureDelimiterStrategy(String userInput) {
        if (isCustomDelimiter(userInput)) {
            stringCalculator.setDelimiterStrategy(new CustomDelimiterStrategy());
        } else {
            stringCalculator.setDelimiterStrategy(new DefaultDelimiterStrategy());
        }
    }
}
