package calculator;

import java.util.List;

public class Adder {
    private final List<String> numList;

    public Adder(List<String> numList) {
        this.numList = numList;
    }

    public int addAll() {
        int sum = 0;
        for(String number : numList) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
