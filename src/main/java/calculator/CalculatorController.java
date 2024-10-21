package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    public void run() {
        printStartText();
        String userInput = removeWhiteSpace(inputData());
        User user = new User(userInput);
        List<String> splitedUserInput = user.getSplitedUserInput();
        List<Integer> numbers = parseInputNumbers(splitedUserInput);
        int result = performAddition(numbers);
        printResult(result);
    }

    private void printStartText() {
        System.out.println(Constants.MESSAGE_START_INPUT);
    }

    private String inputData() {
        return Console.readLine();
    }

    private String removeWhiteSpace(String input) {
        return input.replaceAll("\\s", "");
    }

    private List<Integer> parseInputNumbers(List<String> inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            if (number.equals("")) {
                number = number.replace("", "0");
            }
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private int performAddition(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private void printResult(int result) {
        System.out.printf(Constants.MESSAGE_RESULT_FORMAT + "\n", result);
    }
}