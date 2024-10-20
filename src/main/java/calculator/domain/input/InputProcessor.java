package calculator.domain.input;

import calculator.domain.Separator;

public interface InputProcessor {

    String[] processInput(String input, Separator separator);
}
