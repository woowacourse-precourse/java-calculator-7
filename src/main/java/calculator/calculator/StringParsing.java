package calculator.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringParsing {

    //구분자로 양수 추출
    public List<Integer> parseString(Input input) {
        String regex = String.join("|", input.getDelimiters()); //구분자를 "|"로 나눔 -> split 하기 위해

        // input을 구분자로 split
        String[] numbers = input.getInputString().split(regex);

        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            if (!number.trim().isEmpty()) { // 빈 문자열 체크
                result.add(Integer.parseInt(number.trim())); // 숫자로 변환
            }
        }

        return result;
    }
}
