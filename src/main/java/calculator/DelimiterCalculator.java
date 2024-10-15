package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterCalculator implements Calculator {
    private final List<Character> delimiters;
    private final List<Integer> numbers = new ArrayList<>();

    public DelimiterCalculator(List<Character> delimiters) {
        this.delimiters = delimiters;
    }
    @Override
    public int calculate(String input) {
        addNumbersFromInput(input);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }


    private void addNumbersFromInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        int localNumber = 0;
        for(int i=0; i<input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
                localNumber = localNumber * 10 + Character.getNumericValue(input.charAt(i));
                continue;
            }
            if(delimiters.contains(input.charAt(i))){
                numbers.add(localNumber);
                localNumber = 0;
                continue;
            }
            throw new IllegalArgumentException("Invalid input");
        }
        if(localNumber != 0) numbers.add(localNumber);

    }

}
