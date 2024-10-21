package calculator.domain;

import java.util.List;

public class Calculator {
    private final DelimiterChecker delimiterChecker;

    public Calculator() {
        this.delimiterChecker = new DelimiterChecker();
    }

    public long calculate(String input) {
        delimiterChecker.putString(input);
        List<Integer> numbers = delimiterChecker.getNumbers();
        AddingMachine addingMachine = new AddingMachine(numbers);

        return addingMachine.addNumbers();
    }
}
