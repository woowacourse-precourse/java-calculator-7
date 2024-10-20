package calculator.io.reader;

import java.util.List;

public interface Input {
    String inputString();
    String validateInput(String input);
    List<String> extractSeparator(String input);
}
