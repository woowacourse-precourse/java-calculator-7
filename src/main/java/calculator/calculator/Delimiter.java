package calculator.calculator;

import java.util.List;

public interface Delimiter {

    List<String> extractString(String rawInput);

    boolean applicable(String rawInput);

}
