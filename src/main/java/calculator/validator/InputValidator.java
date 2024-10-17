package calculator.validator;

public class InputValidator implements Validator {
    @Override
    public int validate(String input) {
        int result = 0;

        if (input == null || input.isBlank()) {
            return result;
        }

        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 계산할 수 없습니다.");
        } // end if

        if (input.matches("[0-9]*$")) {
            result = Integer.parseInt(input);
        } // end if

        return result;
    } // validate
} // class