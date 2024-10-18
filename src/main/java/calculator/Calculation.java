package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    Tokenizer tokenizer;
    Adder adder;
    List<Integer> numberlist;

    public Calculation() {
        tokenizer = new Tokenizer();
        adder = new Adder();
        numberlist = new ArrayList<Integer>();
    }

    public int calculate(String input) {
        numberlist = tokenizer.tokenize(input);
        int output = adder.add(numberlist);
        return output;
    }
}
