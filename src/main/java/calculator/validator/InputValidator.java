package calculator.validator;

public class InputValidator {

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

    // TODO: 잘못된 입력이었을 경우에는 예외를 발생시킨다. 입력이 유효한지 검증한다.

}
