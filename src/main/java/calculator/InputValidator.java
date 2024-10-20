package calculator;

public class InputValidator {

    //사용자 입력 검증 : 구분자
    public void isDelimiter(char[] charArray) {
        for (int i = 1; i < charArray.length; i = i + 2) {
            char delimiter = charArray[i];
            if (delimiter != '|' || delimiter != ',') {
                throw new IllegalArgumentException("구분자 입력이 올바르지 않습니다.");
            }
        }
    }


    //사용자 입력 검증 : 양수
    public void isPositiveNumber(char[] charArray) {
        for (int i = 0; i < charArray.length; i = i + 2) {
            char number = charArray[i];
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }
            if (Character.getNumericValue(number) < 0) {
                throw new IllegalArgumentException("양수를 입력하세요.");
            }
        }
    }
}
