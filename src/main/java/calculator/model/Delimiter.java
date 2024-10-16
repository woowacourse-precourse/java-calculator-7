package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Delimiter {

    private ArrayList<Character> delimiters = new ArrayList<>(Arrays.asList(':', ','));

    public void addCustomDelimiter(char newDelimiter) {
        delimiters.add(newDelimiter);
    }
}
