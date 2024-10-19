package calculator;

public class Validator {
    public void validateInput(String input) {
//        if (isEmptyString(input)) {
//            return;
//        }
        if (isNegativeNumber(input)) {
            throw new IllegalArgumentException("음수는 입력할 수 없음");
        }
        if (isInvalidCharacter(input)) {
            throw new IllegalArgumentException("잘못된 문자 포함됨");
        }
    }

    private boolean isNegativeNumber(String input) {
        return input.contains("-");
    }

//    private boolean isEmptyString(String input) {
//        return input.isEmpty();
//    }

    private boolean isInvalidCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && !isDelimiter(c)) {
                return true;
            }
        }
        // TODO 정규표현식으로 바꾸기
        return false;
    }

    private boolean isDelimiter(char c) {
        return InputParser.isDelimiter(String.valueOf(c));
    }
}
