package calculator.validator;

public class ParserValidator {
    public boolean isCustomSeparator(int inputSeparatorArraySize) {
        if (inputSeparatorArraySize < 2) {
            return false;
        } else if (inputSeparatorArraySize > 2) {
            throw new IllegalArgumentException("구분자 형식이 중복 입력되었습니다.");
        }
        return true;
    }

    // TODO: 오직 구분자만 입력되었는지 확인한다.

    // TODO: 구분자가 유효한지 확인한다.

    // TODO: 구분자가 숫자인지 확인한다.

    // TODO: 구분자가 중복되어 입력되었는지 확인한다.
}
