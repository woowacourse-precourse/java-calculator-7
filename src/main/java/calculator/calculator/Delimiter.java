package calculator.calculator;

import java.util.List;

public interface Delimiter {

    List<String> extractString(String input);

    boolean applicable(String input);

}
