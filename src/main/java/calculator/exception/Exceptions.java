package calculator.exception;

public class Exceptions {

    public static IllegalArgumentException onlyNumberInput() {
        return new IllegalArgumentException("숫자만 입력해주세요.");
    }

    public static IllegalArgumentException onlyPlusNumber() {
        return new IllegalArgumentException("양수만 입력해주세요.");
    }
}
