package calculator.validator;

public class CustomSeparatorValidator {
    private String input;
    public CustomSeparatorValidator(String input) {
        this.input = input;
        if('0'<= input.charAt(0) || input.charAt(0) <= '9') return;
        ValidateCustomSeparatorRule();
        ValidateIsCustomSeparatorNumber();
    }
    private void ValidateCustomSeparatorRule() {
        if(input.substring(0,1)!="//" || input.substring(3,4)!="\\n")
            new IllegalArgumentException("커스텀 구분자 지정 규칙에 어긋납니다.");
    }
    private void ValidateIsCustomSeparatorNumber() {
        if ('0'<= input.charAt(2) || input.charAt(2) <= '9') {
            new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
        }
    }
}
