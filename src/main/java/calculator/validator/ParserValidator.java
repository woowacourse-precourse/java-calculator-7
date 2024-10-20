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

    public boolean isOnlySeparator(String numberString) {
        if (numberString.matches("^\\d.*")) {
            return false;
        }
        return true;
    }

    private boolean isSeparatorNumber(int inputSeparatorASCIIIndex) {
        if (inputSeparatorASCIIIndex >= 48 && inputSeparatorASCIIIndex <= 57) {
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다.");
        }
        return false;
    }

    // TODO: 구분자가 중복되어 입력되었는지 확인한다.


    // TODO: 구분자가 유효한지 확인한다.

}
