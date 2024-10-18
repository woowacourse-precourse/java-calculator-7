package calculator;

class InputValidator {
    public void validate(String input) {
        if (input.startsWith("//") && !input.contains("\n")) {
            throw new IllegalArgumentException("커스텀 구분자 지정 후 '\\n'이 없습니다.");
        }
    }
}