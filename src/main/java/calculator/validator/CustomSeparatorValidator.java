package calculator.validator;

public class CustomSeparatorValidator {
    private String input;
    public CustomSeparatorValidator(String input) {
        this.input = input;
        if(input.charAt(0)!='/') return;
        ValidateCustomSeparatorRule();
        ValidateIsCustomSeparatorNumber();
    }
    private void ValidateCustomSeparatorRule() {
        if(!input.substring(0,2).equals("//") || !input.substring(3,5).equals("\\n"))
            throw new IllegalArgumentException("커스텀 구분자 지정 규칙에 어긋납니다.");
    }
    private void ValidateIsCustomSeparatorNumber() {
        if ('0'<= input.charAt(2) && input.charAt(2) <= '9') {
            throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
        }
    }
}
