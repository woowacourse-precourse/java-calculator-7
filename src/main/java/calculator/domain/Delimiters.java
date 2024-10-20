package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private final List<Character> delimiters = new ArrayList<>();

    public Delimiters(){
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters(){
        delimiters.add(',');
        delimiters.add(':');
    }

    public List<Character> getDelimiters(){
        return delimiters;
    }

}
