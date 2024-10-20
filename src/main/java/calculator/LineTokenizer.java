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
            if(delimiters.contains(input.charAt(i))){
                // 구분자가 연속으로 나오는 경우 방어로직
                if(localNumber != 0){
                    numbers.add(localNumber);
                }
                localNumber = 0;
                continue;
            }
            if(Character.isDigit(input.charAt(i))){
                int number = Character.getNumericValue(input.charAt(i));
                // 0으로 시작하는 숫자는 유효하지 않다.
                if(number == 0 && localNumber == 0) throw new IllegalArgumentException("Number cannot start with 0");
                localNumber = localNumber * 10 + number;
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

