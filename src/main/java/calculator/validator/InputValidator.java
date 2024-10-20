package calculator.validator;

public class InputValidator {
    public boolean isValidInput(String input) {
        if (isNegativeNumber(input)) {
            throw new IllegalArgumentException("음수가 포함되었습니다.");
        }
        if (!isValidFormat(input)) {
            throw new IllegalArgumentException("커스텀 구분자가 잘못된 형식으로 입력되었습니다.");
        }
        return true;
    }

    private boolean isNegativeNumber(String input) {
        return input.matches("-\\d+");
    }

    private boolean isValidFormat(String input) {
        if (input.matches("^//.*")) {
            return input.contains("\\n");
        }
        if (!isSimpleString(input)) {
            return true;
        }
        return false;
    }

    private boolean isSimpleString(String input) {
        if (input.matches("^\\d.*")) {
            return false;
        } else if (input.matches("^[,:].*|^//.*")) {
            return false;
        }
        return true;
    }
}
