package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    // 문자열을 쉼표와 콜론을 기준으로 분리 후, 숫자로 변환하는 메서드
    public List<Integer> splitAndConvert(String input) {
        // null 또는 빈 문자열 처리; 리스트에 0을 담아 반환
        if (input == null || input.isEmpty()) {
            return Arrays.asList(0);
        }

        List<Integer> num = Arrays.stream(input.split("[,:]")) // input을 쉼표, 콜론으로 분리 후 스트림으로 변환
                                  .map(s -> s.trim()) // stream에 담긴 문자열 요소 각각에 대해 공백 제거
                                  .map(s -> Integer.parseInt(s)) // 각 문자열을 정수로 변환
                                  .collect(Collectors.toList()); // 스트림으로 처리한 데이터들을 리스트로 변환

        return num;
    }
}
