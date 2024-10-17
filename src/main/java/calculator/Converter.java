package calculator;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    /**
     * 문자열 배열을 정수 리스트로 변환
     */
    public List<Integer> convertToNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }
}
