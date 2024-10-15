package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private Set<Character> delimiterSet;

    public Delimiter(){
        this.delimiterSet = new HashSet<>();
        delimiterSet.add(',');
        delimiterSet.add(':');
    }

    public void updateDelimiter(Character delimiter){
        delimiterSet.add(delimiter);
    }
}
