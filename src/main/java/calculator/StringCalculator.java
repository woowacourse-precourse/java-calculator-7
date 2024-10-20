package calculator;

import static calculator.NumberList.extractNumbersFrom;
import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";

    public void run() {
        String input = askForStringInput();

        String[] splitedInput = splitInputByDelimiter(input);

        int sum = extractNumbersFrom(splitedInput).getSum();

        showSum(sum);

        close();
    }

    private String askForStringInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    private String[] splitInputByDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX)
                ? splitByCustomDelimiter(input)
                : splitByDefaultDelimiter(input);
    }

    private String[] splitByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private String[] splitByCustomDelimiter(String input) {
        String[] splitedInput = input.split(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = getCustomDelimiter(splitedInput[0]);
        return splitedInput[1].split(customDelimiter);
    }

    private String getCustomDelimiter(String input) {
        int customDelimiterIndex = input.length() - 1;
        char customDelimiter = input.charAt(customDelimiterIndex);
        return String.valueOf(customDelimiter);
    }

    private void showSum(int sum) {
        System.out.println("결과 : " + sum);
    }
}