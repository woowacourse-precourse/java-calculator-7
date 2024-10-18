package calculator;

import java.util.List;

public class Calculator {
    public int getTotal(List<String> splitInput) {
        int total = 0;

        for (String number : splitInput) {
            total += Integer.parseInt(number);
        }

        return total;
    }
}
