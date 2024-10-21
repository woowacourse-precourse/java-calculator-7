package calculator.domain;

import java.util.ArrayList;

public class Calculator {
    private static Calculator instance = new Calculator();
    private Calculator() {}

    public static Calculator getInstance() {
        return instance;
    }

    public int add(ArrayList<Integer> numbers) {
        int result = 0;
        for (int n : numbers) {
            result += n;
        }
        return result;
    }
}
