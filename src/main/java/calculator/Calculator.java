package calculator;

public class Calculator {

    // 쉼표(,) 또는 콜론(:)을 구분자로 숫자를 추출하는 메서드
    public String[] extractNumbers(String input) {
        // 빈 문자열을 받았다면 0이 담긴 배열을 반환
        if (input.isEmpty()) {
            return new String[]{"0"};
        }

        // 쉼표(,) 또는 콜론(:)을 기준으로 숫자를 분리
        return input.split("[,:]");
    }
}
