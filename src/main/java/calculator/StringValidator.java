package calculator;

public class StringValidator {
    public void validateNegativeNumber(String[] splitedString) {
        for (String numberStr : splitedString) {
            if (Integer.parseInt(numberStr.trim()) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다");
            }
        }
    }
}
