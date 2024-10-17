package calculator.domain;

import calculator.domain.enums.BasicDelimiter;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {

    Set<Character> delimiterSet = new HashSet<>();

    public Delimiter() {
        registerBasicDelimiters(BasicDelimiter.values());
    }

    public void registerBasicDelimiters(BasicDelimiter[] delimiters) {
        for (BasicDelimiter basicDelimiter : delimiters) {
            delimiterSet.add(basicDelimiter.getSymbol());
        }
    }

    public void addCustomDelimiter(char customDelimiter) {
        delimiterSet.add(customDelimiter);
    }

    public boolean isRegisteredDelimiter(char delimiter) {
        return delimiterSet.contains(delimiter);
    }

    public Set<Character> getDelimiterSet() {
        return delimiterSet;
    }

}
