package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Optional;

public class Input {

    public static Optional<String> input() {
        return Optional.of(Console.readLine());
    }
}
