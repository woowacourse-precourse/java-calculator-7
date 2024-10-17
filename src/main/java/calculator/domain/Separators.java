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

    public boolean contain(char separator) {
        for (Separator s : separators) {
            if (s.isSame(separator)) {
                return true;
            }
        }
        return false;
    }

    public String makePattern() {
        StringBuilder sb = new StringBuilder(Condition.LEFT_SQUARE_BRACKET);
        for (Separator s : separators) {
            String str = s.toString();
            if (str.equals(Condition.BACKSLASH)) {
                sb.append(Condition.BACKSLASH_ESCAPE);
            } else if (str.equals(Condition.RIGHT_SQUARE_BRACKET) || str.equals(Condition.LEFT_SQUARE_BRACKET)) {
                sb.append(Condition.SQUARE_BRACKETS_ESCAPE);
            }
            sb.append(str);
        }

        sb.append(Condition.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }
}