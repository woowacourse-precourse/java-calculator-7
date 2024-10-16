package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

public class InputView {

    public List<Integer> getAdditionNumbers() {
        String input = Console.readLine();

        if (input.isBlank()) {
            return Collections.emptyList();
        }

        return null;
    }
}
