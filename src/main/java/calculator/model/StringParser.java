package calculator.model;

import calculator.util.DelimiterUtils;
import java.util.Arrays;
import java.util.List;

// 입력 문자열을 파싱하는 클래스
public class StringParser {

    // 입력 문자열을 파싱하여 숫자 리스트를 반환하는 메서드
    public List<String> parseInput(String input) {
        String[] numbersArray = DelimiterUtils.splitByDelimiter(input);
        return Arrays.asList(numbersArray);
    }

}