package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private static Set<Character> delimiterSet;

    public Delimiter(){
        delimiterSet = new HashSet<>();
        delimiterSet.add(',');
        delimiterSet.add(':');
    }

    public static void updateDelimiter(Character delimiter){
        delimiterSet.add(delimiter);
    }
}
