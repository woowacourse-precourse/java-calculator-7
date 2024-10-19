package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DEFAULT_NUMBER_DELIMITER_REGEX = "[,:]";

    private InputView() {
    }

    public static List<Integer> inputNumbers() {
        String string = input();
        return Arrays.stream(string.split(DEFAULT_NUMBER_DELIMITER_REGEX))
                .map(InputView::toInt)
                .toList();
    }

    private static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("형식이 올바르지 않습니다.", e);
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
