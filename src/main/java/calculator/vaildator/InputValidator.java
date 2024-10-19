package calculator.vaildator;

public class InputValidator {

    public void validateInputArray(String[] inputArr) {
        for (String num : inputArr) {
            if (num.isEmpty()) {
                throw new IllegalArgumentException("숫자 입력이 제대로 되지 않았습니다.");
            }

            if (num.matches("0+")) {
                throw new IllegalArgumentException("0은 입력할 수 없습니다.");
            }

            if (num.contains("-")) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            if (!num.matches("[0-9]+")) {
                throw new IllegalArgumentException("숫자, 구분자 이외의 문자가 들어왔습니다.");
            }

            try {
                if (Integer.parseInt(num) > Integer.MAX_VALUE - 1) {
                    throw new IllegalArgumentException("너무 큰 숫자는 입력할 수 없습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 너무 큽니다.");
            }
        }
    }
}
