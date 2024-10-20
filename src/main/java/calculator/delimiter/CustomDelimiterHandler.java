package calculator.delimiter;

import calculator.DelimiterHandler;

public class CustomDelimiterHandler implements DelimiterHandler {

    @Override
    public String[] split(String input) {
        // 커스텀 구분자 추출: //과 \n 사이의 구분자를 추출
        String delimiter = input.substring(2, input.indexOf("\n"));

        // 실제 숫자 부분 추출
        String numbers = input.substring(input.indexOf("\n") + 1);

        // 커스텀 구분자로 분리
        return numbers.split(delimiter);
    }

    // 커스텀 구분자가 포함되었는지 확인하는 메서드
    public static boolean isCustomDelimiter(String input) {
        // //으로 시작하고 \n이 포함된 경우 커스텀 구분자라고 판단
        return input.startsWith("//") && input.contains("\n");
    }
}
