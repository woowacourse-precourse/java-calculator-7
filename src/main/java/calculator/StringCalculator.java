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

        // 기본 구분자
        String separator = "[,;]";

        // input = "//;\n1;2;3

        // "//"로 문자열이 시작하는 경우
        if (input.startsWith("//")) {
            int separatorEndIndex  = input.indexOf("\n"); // 커스텀 구분자가 끝나는 인덱스 파악
            separator = input.substring(2, separatorEndIndex ); // 2번인덱스부터 \n 전까지의 인덱스를 커스텀 구분자로 설정
            input = input.substring(separatorEndIndex+1); // 커스텀 문자열을 설정하는 문자열을 제거 -> 실제 계산부만 남김
        }

        List<Integer> num = Arrays.stream(input.split(separator)) // input을 쉼표, 콜론으로 분리 후 스트림으로 변환
                                  .map(s -> s.trim()) // stream에 담긴 문자열 요소 각각에 대해 공백 제거
                                  .map(s -> Integer.parseInt(s)) // 각 문자열을 정수로 변환
                                  .collect(Collectors.toList()); // 스트림으로 처리한 데이터들을 리스트로 변환
        return num;
    }
}
