package calculator;

import calculator.model.CalculationInput;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_INPUT_REGEX = "^//(.*?)\\\\n(.*)";

    public static void main(String[] args) {

        CalculationInput calculationInput = getCalculationInput();

        int[] extractedNumbers = extractNumbers(calculationInput);
        int result = calculate(extractedNumbers);
        showResult(result);
    }

    private static CalculationInput getCalculationInput() {

        String userInput = getUserInput();

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_INPUT_REGEX);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.matches()) {
            String delimiter = makeDelimiterRegex(matcher.group(1));
            String inputString = matcher.group(2);

            return new CalculationInput(delimiter, inputString);
        }

        return new CalculationInput(DEFAULT_DELIMITER_REGEX, userInput);
    }

    private static String getUserInput() {
        System.out.println(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }

    private static int[] extractNumbers(CalculationInput calculationInput) {

        String inputString = calculationInput.inputString();
        String delim = calculationInput.delimiter();

        String[] extractedStringNumbers = inputString.split(delim);
        return Arrays.stream(extractedStringNumbers).mapToInt(Integer::parseInt).toArray();
    }

    private static String makeDelimiterRegex(String DelimString) {
        return "[" + DelimString + "]";
    }

    private static int calculate(int[] numbersToSum) {

        int sum = 0;
        for (int number : numbersToSum) {
            sum += number;
        }

        return sum;
    }

    private static void showResult(int result) {
        System.out.printf("결과 : %d%n", result);
        Console.close();
    }
}
