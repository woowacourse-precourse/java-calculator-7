package calculator.validator;

public class CustomSeparatorValidator {

    public CustomSeparatorValidator(String input) {

        if (input.charAt(0) != '/') return;
        ValidateCustomSeparatorRule(input);
        ValidateIsCustomSeparatorNumber(input);
    }

    private void ValidateCustomSeparatorRule(String input) {
        if (!input.substring(0, 2).equals("//") || !input.substring(3, 5).equals("\\n"))
            throw new IllegalArgumentException("커스텀 구분자 지정 규칙에 어긋납니다.");
    }

    private void ValidateIsCustomSeparatorNumber(String input) {
        if (Character.isDigit(input.charAt(2))) {
            throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
        }
    }
}
