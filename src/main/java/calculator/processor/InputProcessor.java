package calculator.processor;

import calculator.domain.Separator;

public interface InputProcessor {

    String[] processInput(String input, Separator separator);
}
