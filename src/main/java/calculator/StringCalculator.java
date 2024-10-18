package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    // 문자열을 쉼표와 콜론을 기준으로 분리 후, 숫자로 변환하는 메서드
    public static List<Integer> splitAndConvert(String input) {
        // null 또는 빈 문자열이 들어오면 IllegalArgumentException 발생
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 없습니다.");
        }

        // 기본 구분자
        String separator = "[,:]";

        // "//"로 문자열이 시작하는 경우
        if (input.startsWith("//")) {
            int separatorEndIndex = input.indexOf("\\n"); // 커스텀 구분자가 끝나는 인덱스 파악

            if (separatorEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 입력 형식입니다.");
            }

            separator = input.substring(2, separatorEndIndex); // 2번인덱스부터 \n 전까지의 인덱스를 커스텀 구분자로 설정
            input = input.substring(separatorEndIndex + 2); // 커스텀 문자열을 설정하는 문자열을 제거 -> 실제 계산부만 남김

            // 커스텀 구분자가 정규식의 특수문자일 경우, 이스케이프 처리
            separator = Pattern.quote(separator);
        }

        try {
            return Arrays.stream(input.split(separator))
                         .map(String::trim) // 공백 제거
                         .map(Integer::parseInt) // 문자열을 정수로 변환
                         .collect(Collectors.toList()); // 스트림으로 처리한 데이터들을 리스트로 변환
        } catch (NumberFormatException e) {
            throw new NumberFormatException("수식이 잘못되었습니다.");
        }
    }

    public static int sumNumber(List<Integer> number) {
        return number.stream().mapToInt(Integer::intValue) // Integer -> int 변환
                              .sum(); // 스트림 내의 정수 합산 후 반환
    }
}