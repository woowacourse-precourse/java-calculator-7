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
        String input = InputView.startInput();
        String[] stringNumber = splitString(input);
        int[] numbers = parseInteger(stringNumber);
        int result = calculate(numbers);
        OutputView.printResultMessage(result);
    }

    private String[] splitString(String input) {
        return input.trim().split(REGEX);
    }

    private int[] parseInteger(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
    }

    private int calculate(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
