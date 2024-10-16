package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<Character> separators;
    String input;

    public Calculator(String s) {
        separators = new ArrayList<Character>();
        separators.add(',');
        separators.add(':');
        input = s;
    }

}
