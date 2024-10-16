package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> operands = new ArrayList<>();

    public Calculator(String input) {
        String[] results = input.split("[,;]");

        for (String element : results) {
            this.operands.add(Integer.parseInt(element));
        }
    }

    public int sum() {
        return operands.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
