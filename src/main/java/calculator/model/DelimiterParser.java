package calculator.model;

public class DelimiterParser {

    // 구분자를 파싱하고 입력 문자열에서 구분자를 제거한 결과를 반환
    public String[] parse(String input) {
        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex != -1) {
                delimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
                input = input.substring(delimiterEndIndex + 1); // 문자열에서 커스텀 구분자 부분 제거
            }
        }
        return input.split(delimiter); // 구분자로 문자열을 분리하여 반환
    }
}
