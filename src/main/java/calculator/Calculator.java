package calculator;

public class Calculator {
    String[] input;
    public Calculator(String[] input) {
        this.input = input;
    }
    int calculate() {
        int result = 0;
        try {
            for (String num : input) {
                int temp = Integer.parseInt(num);
                if (temp < 0) {
                    throw new IllegalArgumentException("올바르지 못한 입력", new Throwable("양수만 연산이 가능합니다."));
                }
                result += temp;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 못한 입력", new Throwable("양수만 연산이 가능합니다."));
        }
        return result;
    }
}
