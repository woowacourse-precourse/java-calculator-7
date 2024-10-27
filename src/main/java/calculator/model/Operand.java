package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Operand {
    private List<Integer> numbers = new ArrayList<>();

    public Operand(List<String> inputStrings) {
        for (int i = 0; i < inputStrings.size(); i++) {
            try {
                int element;
                element = Integer.valueOf(inputStrings.get(i));
                if (element < 0) {
                    throw new IllegalArgumentException();
                }
                numbers.add(element);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
