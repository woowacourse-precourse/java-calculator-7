package calculator.model;

public class InputValidator {

    public void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf('\n');
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
        }
    }
}