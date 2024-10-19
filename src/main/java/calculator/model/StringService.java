package calculator.model;

import java.util.List;

public interface StringService {
    List<String> parse(String input);

    List<Integer> toIntegerList(List<String> stringList);
}
