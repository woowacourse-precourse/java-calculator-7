package calculator;

public class InputValidator {

    public void delimiterValidate(String delimiter) {
        try {
            Integer.parseInt(delimiter);
            throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
        } catch (NumberFormatException e) {
            return;
        }
    }

    public void validate(String[] numbers) {
        for (String number : numbers) {
            int num;
            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력 입니다.");
            }
            if (num < 0) {
                throw new IllegalArgumentException("음수가 포함되어 있습니다.");
            }
        }
    }
}
