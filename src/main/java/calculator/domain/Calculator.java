package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public List<Character> delimiters = new ArrayList<>();


    public void init() {
        this.delimiters.add(':');
        this.delimiters.add(',');
    }

    public String getDelimitersAsString() {
        return this.delimiters.toString();
    }
}
