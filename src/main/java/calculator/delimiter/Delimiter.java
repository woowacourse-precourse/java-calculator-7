package calculator.delimiter;

import java.util.List;

public interface Delimiter {

    List<Integer> extractNumbers(String input);

    boolean applicable(String input);

}
