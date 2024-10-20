package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {
    public List<Integer> extractNumbers(String numbersString, String delimiters) {
        String[] tokens = numbersString.split(delimiters);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if(!token.matches("\\d+")) {
                throw new IllegalArgumentException("양수 이외의 값이 포함되어 있습니다.");
            }
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }


}
