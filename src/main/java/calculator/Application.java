package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.calculateStrategy.EmptyStringCalculateStrategy;
import calculator.calculateStrategy.IntegerCalculateStrategy;
import calculator.delimiterStrategy.CustomDelimiterStrategy;
import calculator.delimiterStrategy.DefaultDelimiterStrategy;
import calculator.delimiterStrategy.DelimiterStrategy;
import calculator.numberStrategy.SimpleNumberStrategy;
import java.util.NoSuchElementException;

public class Application {
    private static final String inputPhrase = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputPhrase = "결과 : ";

    public static void main(String[] args) {
        System.out.println(inputPhrase);
        String userInput;
        try {
            userInput = readLine();
            userInput = userInput.replace("\\n", "\n");

            StringCalculator stringCalculator = new StringCalculator(userInput, configureDelimiterStrategy(userInput),
                    new SimpleNumberStrategy(), new IntegerCalculateStrategy());

            System.out.println(outputPhrase + stringCalculator.operate());
        } catch (NoSuchElementException e) {
            StringCalculator stringCalculator = new StringCalculator("", new CustomDelimiterStrategy(),
                    new SimpleNumberStrategy(),
                    new EmptyStringCalculateStrategy());
            System.out.println(outputPhrase + stringCalculator.emptyStringOperate());
        }
    }

    private static boolean isCustomDelimiter(String userInput) {
        return userInput.startsWith(StringCalculator.getStartCustomPattern())
                && userInput.contains(StringCalculator.getEndCustomPattern());
    }

    private static DelimiterStrategy configureDelimiterStrategy(String userInput) {
        if (isCustomDelimiter(userInput)) {
            return new CustomDelimiterStrategy();
        } else {
            return new DefaultDelimiterStrategy();
        }
    }
}
