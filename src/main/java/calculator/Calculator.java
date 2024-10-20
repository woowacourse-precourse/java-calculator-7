package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private String input;
    private List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    public Calculator(String input) {
        this.input = input != null ? input : "";
    }
}