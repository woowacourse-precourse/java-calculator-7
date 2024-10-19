package calculator;

import java.util.List;
import java.util.Set;

public interface Parser {

    public Character getCustomParser(String input);
    public List<Integer> getIntegerList(String input, Set<Character> separators);
}
