package calculator.domain.calculator;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private Set<Character> set =  new HashSet<>();

    public Delimiter(){
        set.add(','); set.add(':');
    }

    void addDelimiter(char ch){
        set.add(ch);
    }

    public boolean isDelimiter(char ch) {
        if(this.set.contains(ch)) return true;
        return false;
    }
}
