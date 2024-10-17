package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerPrinter {
    private String userInput;
    private List<String> delimiters = new ArrayList<>(Arrays.asList(",", ";"));
    private ArrayList<Integer> integers;

    public IntegerPrinter(String userInput) {
        this.userInput = userInput;
    }

    public ArrayList<Integer> print() {
        return integers;
    }
}
