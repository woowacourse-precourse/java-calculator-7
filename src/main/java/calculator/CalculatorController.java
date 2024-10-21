package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
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

    private List<String> splitUserInput(String input) {
        if (Validator.isCustomFormat(input)) {
            return customSplit(input);
        }
        return defaultSplit(input);
    }

    private List<String> defaultSplit(String input) {
        return Arrays.asList(input.split(Constants.REGEX_DEFAULT_SEPARATOR, -1));
    }

    private List<String> customSplit(String input) {
        Matcher matcher = customPattern.matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String content = matcher.group(2);
            return Arrays.asList(content.split(Pattern.quote(customSeparator), -1));
        }
        throw new IllegalArgumentException(Constants.ERROR_INVALID_CUSTOM_FORMAT);
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
}
