package calculator.calculator;

import java.util.List;

public interface Delimiter {

    List<String> tokenize(String rawInput);

    boolean applicable(String rawInput);

}
