package calculator.input;

import java.util.List;

public interface InputHandlerImpl {
    List<Long> inputProcessor();
    String convertInput(String input);
    List<Long> getNumbers(String input);
}