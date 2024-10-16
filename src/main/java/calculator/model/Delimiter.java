package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private static Set<Character> delimiterSet = new HashSet<>();

    static {
        delimiterSet.add(',');
        delimiterSet.add(':');
    }

    public static void updateDelimiter(Character delimiter){
        delimiterSet.add(delimiter);
    }

    public static boolean isDelimiter(String str){
        char ch = str.charAt(0);
        return delimiterSet.contains(ch);
    }
}
