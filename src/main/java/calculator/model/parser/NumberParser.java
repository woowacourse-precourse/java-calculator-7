package calculator.model.parser;

import java.util.List;

public interface NumberParser {
    boolean canParse(String[] userInput);
    List<Number> parse(String[] userInput);
}
