package calculator.service;

import java.util.List;
import java.util.Set;

public interface Parser {

    Character getCustomParser(String input);
    List<Integer> getIntegerList(String input, Set<Character> separators);
}
