package calculator.validator;

public class InputValidator {

    private boolean isNegativeNumber(String input) {
        return input.matches("-\\d+");
    }

    // TODO: 잘못된 입력이었을 경우에는 예외를 발생시킨다. 입력이 유효한지 검증한다.

    // TODO: 커스텀 구분자를 형식에 맞게 입력했는지 확인한다.

    // TODO: 숫자 또는 기본 구분자가 아닌 단순 문자로 시작되는지 확인한다.
}
