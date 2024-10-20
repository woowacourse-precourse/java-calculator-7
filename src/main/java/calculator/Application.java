package calculator;

import calculator.model.CalculationInput;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String DEFAULT_DELIMITER = ",:";
    private static final String CUSTOM_DELIMITER_INPUT_REGEX = "^//(.*?)\\\\n(.*)";
    private static final String EMPTY_INPUT = "";

    public static void main(String[] args) {

        int result = 0;
        CalculationInput calculationInput = getCalculationInput();

        if (!calculationInput.inputString().equals(EMPTY_INPUT)) {
            ArrayList<Integer> extractedNumbers = extractNumbers(calculationInput);
            result = calculate(extractedNumbers);
        }

        showResult(result);
    }

    private static CalculationInput getCalculationInput() {

        String userInput = getUserInput();
        String delimiter = DEFAULT_DELIMITER;
        String inputString = userInput;

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_INPUT_REGEX);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.matches()) {
            delimiter = matcher.group(1);
            inputString = matcher.group(2);
        }

        if (inputString.trim().isEmpty()) {
            inputString = EMPTY_INPUT;
        }

        return new CalculationInput(delimiter, inputString);
    }

    private static String getUserInput() {
        System.out.println(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }

    private static ArrayList<Integer> extractNumbers(CalculationInput calculationInput) {

        String inputString = calculationInput.inputString();
        String delim = calculationInput.delimiter();

        ArrayList<Integer> numbersToSum = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, delim);

        while (stringTokenizer.hasMoreTokens()) {
            numbersToSum.add(Integer.valueOf(stringTokenizer.nextToken()));
        }

        return numbersToSum;
    }

    private static int calculate(ArrayList<Integer> numbersToSum) {

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
