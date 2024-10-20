package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 구분자를 기준으로 문자열을 자른 후, 정수 값으로 변환하는 클래스
 */
public class DelimiterTokenizer {

    /**
     * 구분자를 기준으로 문자열을 자르고,
     * 잘린 문자들을 정수로 변환한 후,
     * List에 담아서 전달
     *
     * @param delimiterResult 구분자 추출 후 결과 값
     * @return 변환된 정수 형태의 List
     */
    public List<Integer> getNumbers(DelimiterResult delimiterResult) {
        List<Integer> numbers = new ArrayList<>(); // 반환할 정수 List
        String numberInput = delimiterResult.getNumberString(); // 구분자를 기준으로 자를 문자열
        Set<Character> delimiters = delimiterResult.getDelimiters(); // 구분자 목록
        String buffer = ""; // 문자열 형태의 정수 buffer

        for (int i = 0; i < numberInput.length(); i++) {
            Character curChar = numberInput.charAt(i); // 현재 index의 문자

            // 현재 문자가 숫자인 경우
            if (Character.isDigit(curChar)) {
                buffer += curChar;
            }
            // 문자인 경우
            else {
                if (buffer.isBlank() || !delimiters.contains(curChar)) {
                    throw new IllegalArgumentException("입력이 올바르지 않습니다.");
                }
                numbers.add(Integer.parseInt(buffer));
                buffer = "";
            }
        }

        // 남은 buffer check, 문자열의 마지막이 숫자인 경우 버퍼에 남게된다.
        if (buffer.isBlank()) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        numbers.add(Integer.parseInt(buffer));

        return numbers;
    }
}
