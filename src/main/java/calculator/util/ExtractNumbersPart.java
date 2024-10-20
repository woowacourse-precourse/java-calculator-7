package calculator.util;

public class ExtractNumbersPart {
    // 커스텀 구분자 이후 숫자파트 추출하는 메서드
    public static String extractNumbersPart(String input) {
        // 마지막 커스텀 구분자 위치 찾기
        int lastDelimiterIndex = input.lastIndexOf("\\n");

        // 커스텀 구분자가 없는 경우 입력 그대로 반환
        if (lastDelimiterIndex == -1) {
            return input.trim();
        }

        // 마지막 \n 이후 숫자 부분 추출
        return input.substring(lastDelimiterIndex + 2).trim();
    }
}