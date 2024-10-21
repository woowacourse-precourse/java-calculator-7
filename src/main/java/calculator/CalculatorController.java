package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class CalculatorController {
    private final Pattern customPattern = Pattern.compile(Constants.REGEX_CUSTOM_FORMAT);

    private void printStartText() {
        System.out.println(Constants.MESSAGE_START_INPUT);
    }

    private String inputData() {
        return Console.readLine();
    }

    private String removeWhiteSpace(String input) {
        return input.replaceAll("\\s", "");
    }
}
