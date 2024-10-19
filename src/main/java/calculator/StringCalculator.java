package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";

    public void run() {
        String input = askForStringInput();
        String[] extractedNumbers = extractNumbersFrom(input);
        validateInput(extractedNumbers);
        int sum = calulateSum(extractedNumbers);
    }

    private String askForStringInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    private String[] extractNumbersFrom(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return splitByCustomDelimiter(input);
        }
        return splitByDefaultDelimiter(input);
    }

    private static String[] splitByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private String[] splitByCustomDelimiter(String input) {
        String[] splitedInput = input.split(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = extractCustomDelimiter(splitedInput[0]);
        return splitedInput[1].split(customDelimiter);
    }

    private String extractCustomDelimiter(String input) {
        int customDelimiterIndex = input.length() - 1;
        char customDelimiter = input.charAt(customDelimiterIndex);
        return String.valueOf(customDelimiter);
    }

    private void validateInput(String[] numbers) {
        for (String number : numbers) {
            if (number.isEmpty()) continue;
            isNagative(number);
        }
    }

    private void isNagative(String number) {
        if(Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private int calulateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) continue;
            sum += Integer.parseInt(number);
        }
        return sum;
    }

}
