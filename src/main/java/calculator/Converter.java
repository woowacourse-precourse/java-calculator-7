package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 배열을 정수 리스트로 변환하는 클래스입니다.
 */
public class Converter {

    /**
     * 문자열을 정수 리스트로 변환
     */
    public List<Integer> convertToNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }
}
