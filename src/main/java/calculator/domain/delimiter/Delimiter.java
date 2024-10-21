package calculator.domain.delimiter;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {

    private final Set<Character> delimiterSet = new HashSet<>();

    public Delimiter() {
        registerBasicDelimiters(BasicDelimiter.values());
    }

    public void addCustomDelimiter(char customDelimiter) {
        delimiterSet.add(customDelimiter);
    }

    public boolean isRegisteredDelimiter(char delimiter) {
        return delimiterSet.contains(delimiter);
    }

    private void registerBasicDelimiters(BasicDelimiter[] delimiters) {
        for (BasicDelimiter basicDelimiter : delimiters) {
            delimiterSet.add(basicDelimiter.getSymbol());
        }
    }
}
