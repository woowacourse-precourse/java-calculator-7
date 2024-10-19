package calculator;

import java.util.Arrays;

public class Parser {
    public String[] split(String input) {
        String delimiter = "[,:]";

        return input.split(delimiter);
    }
}
