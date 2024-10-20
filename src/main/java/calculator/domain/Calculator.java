package calculator.domain;

public class Calculator {

    // 입력 받은 문자열로부터 숫자 추출& 구분자 처리
    public String[] extractNumbers(String input) {
        String separator = "[,:]";
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\n");
            // 커스텀 구분자 추출시 오류 처리
            if (endIndex != -1) {
                separator = input.substring(2, endIndex);
                if (separator.isEmpty()) {
                    throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
                }
                input = input.substring(endIndex + 1);
            } else {
                throw new IllegalArgumentException("커스텀 구분자가 잘못된 형식입니다.");
            }
        }
        return input.split(separator);
    }

    // 숫자 배열 덧셈 처리
    public int sum(int[] numbersArray) {
        int sum = 0;
        for (int num : numbersArray) {
            sum += num;
        }
        return sum;
    }
}
