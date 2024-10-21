package calculator;

public class Calculator {
    public int run(String input) {
        return cal(input);
    }

    public int cal(String str) {
        // 2. 빈 문자열 입력 처리
        if (str.isEmpty()) return 0;

        // 3. 기본 구분자(쉼표, 콜론)로 문자열 분리
        String delimiter = ",|:";
        String input = str;
        String[] numbers = input.split(delimiter);
    }

}
