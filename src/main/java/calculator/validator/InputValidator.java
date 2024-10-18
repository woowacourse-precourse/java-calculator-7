package calculator.validator;

public class InputValidator {
    public int validate(String input) {
        int result = 0;

        if (input == null || input.isBlank()) {
            return result;
        }

        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자를 지정하지 않고 사용할 수 없습니다.");
        }

        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 계산할 수 없습니다.");
        } // end if

        result = Integer.parseInt(input);
        return result;
    } // validate
} // class