package calculator.domain;

import calculator.constant.Condition;
import java.util.HashSet;
import java.util.Set;

public class Separators {
    private final Set<Separator> separators;

    public Separators() {
        separators = new HashSet<>();
        separators.add(new Separator(Condition.COMMA));
        separators.add(new Separator(Condition.SEMICOLON));
    }

    public void add(char ch) {
        separators.add(new Separator(ch));
    }
}