package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final Input input;
    private final Output output;
    private final Parser parser;

    private List<Integer> inputList;
    private int result;

    public Calculator(Input input, Output output, Parser parser) {
        this.input = input;
        this.output = output;
        this.parser = parser;

        inputList = new ArrayList<>();
        result = 0;
    }

    public void enter() {
        String list = input.readLine();
        inputList = parser.parse(list);
    }

    public void plusAll() {
        for (Integer integer : inputList) {
            result += integer;
        }
    }

    public void print() {
        output.println(result);
    }

    public void clear() {
        inputList = new ArrayList<>();
        result = 0;
    }
}
