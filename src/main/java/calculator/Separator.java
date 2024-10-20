package calculator;

import java.util.List;

public interface Separator {

    List<Long> separate(String userInput);

    List<Long> separateNumbers(String userInput);
}
