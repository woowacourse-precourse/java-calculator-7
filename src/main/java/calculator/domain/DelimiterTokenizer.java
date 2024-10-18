package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DelimiterTokenizer {

    public List<Integer> getNumbers(ExtractResult extractResult) {
        List<Integer> numbers = new ArrayList<>();
        String numberInput = extractResult.getNumberString();
        Set<Character> delimiters = extractResult.getDelimiters();
        String buffer = "";

        for (int i = 0; i < numberInput.length(); i++) {
            Character curChar = numberInput.charAt(i);
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
        // 남은 buffer check
        if(buffer.isBlank()){
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        numbers.add(Integer.parseInt(buffer));
        return numbers;
    }
}
