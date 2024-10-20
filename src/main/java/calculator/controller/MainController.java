package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;

//덧셈할 문자열을 입력해 주세요.
//1,2:3
//결과 : 6
public class MainController {

    private static final String REGEX = "[,;]";

    private MainController() {
    }

    public static MainController create() {
        return new MainController();
    }

    public void run() {
        final String input = InputView.startInput();
        final String[] stringNumber = splitString(input);
        final int[] numbers = parseInteger(stringNumber);
        final int result = calculate(numbers);
        OutputView.printResultMessage(result);
    }

    private String[] splitString(final String input) {
        return input.trim().split(REGEX);
    }

    private int[] parseInteger(final String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
    }

    private int calculate(final int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
