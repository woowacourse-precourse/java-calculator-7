package calculator;

import java.util.Arrays;
import java.util.List;


public class CalculatorParser {

    public static List<Integer> parse(String text) {
        return Arrays.stream(text.split("[,:]")).map(Integer::valueOf).toList();
    }
}
