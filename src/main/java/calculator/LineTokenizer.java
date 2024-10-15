package calculator;

import java.util.ArrayList;
import java.util.List;

public class LineTokenizer {
    private final List<Character> delimiters;

    public LineTokenizer(List<Character> delimiters) {
        this.delimiters = delimiters;
    }

    public List<Integer> tokenize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        List<Integer> numbers = new ArrayList<>();

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

        return numbers;
    }

    public void addDelimiter(Character delimiter) {
        delimiters.add(delimiter);
    }
}

