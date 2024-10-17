package calculator;

import calculator.input.InputString;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputString input = new InputString();
        String st = input.input();

        List<String> separators = input.findSeparator(st);

    }
}
