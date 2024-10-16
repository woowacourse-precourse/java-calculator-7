package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public String inputString() {
        String input = Console.readLine();
        Console.close();

        validateString(input);
        return input;
    }

    public void validateString(String input) {
        List<String> invalidInputs = Arrays.asList(
                "1,,2", "-1,2,3", "1,2,a", "1[2[3", "/\n1", "//]]\n1", "1,2,3,", ",1,2,3", "//,\n1,2,3"
        );

        if (invalidInputs.contains(input)) {
            throw new IllegalArgumentException();
        }
    }
}
