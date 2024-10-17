package calculator;

public class InputValidator {

    public void validate(String[] numbers) {
        for (String number : numbers) {
            int num;
            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식이 포함되어 있습니다.");
            }
            if (num < 0) {
                throw new IllegalArgumentException("음수가 포함되어 있습니다.");
            }
        }
    }
}
