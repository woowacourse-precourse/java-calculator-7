package calculator.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    private final ArrayList<Integer> numbers;
    private final Set<String> seperators;

    public Calculator() {
        numbers = new ArrayList<>();
        seperators = new HashSet<>();
        seperators.add(",");
        seperators.add(":");
    }

    public void addNumber(String number) {
        numbers.add(Integer.parseInt(number.trim()));
    }

    public void addSeperator(String seperator) {
        seperators.add(seperator);
    }

    public Set<String> getSeperators() {
        return seperators;
    }

    public int calculate() {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
