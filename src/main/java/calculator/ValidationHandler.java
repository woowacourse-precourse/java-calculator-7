package calculator;

public class ValidationHandler {

    public void isNegativeNumber(String[] numbers) {
        for(String number : numbers) {
            if (number.charAt(0) == '-') {
                throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
            }
        }
    }

}
