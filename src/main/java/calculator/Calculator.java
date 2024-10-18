package calculator;

import java.util.List;

public class Calculator {
    public int total;

    public void getTotal(List<String> splitInput) {
        for (String number : splitInput) {
            total += Integer.parseInt(number);
        }
    }
}
