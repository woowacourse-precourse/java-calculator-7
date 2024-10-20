package calculator.model.validator;

import static calculator.util.Constants.InputIsNull;

public class DefaultValidator implements InputValidator {

    @Override
    public boolean validate(String input) {
        if (isBlank(input)) {
            return InputIsNull;
        }
        return !InputIsNull;
    }

    @Override
    public void validateNumbers(String[] splitStrings) {
        for (String str : splitStrings) {
            try {
                int num = Integer.parseInt(str);
                validateIsMinusNumber(num); // 음수 여부 검증
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 형식으로 입력해주세요!");
            }
        }
    }

    @Override
    public String findCustomDelimiter(String input) {
        if(input.charAt(0) != '/') return ""; //커스텀 구분자 존재 여부 확인
        validateCustomDividerFormat(input); //커스텀 구분자 형식 체크
        return String.valueOf(input.charAt(2)); //커스텀 구분자 반환
    }

    private boolean isBlank(String input){
        return input.equals("") ? true : false;
    }

    private void validateIsMinusNumber(int number){
        if(number<0){
            throw new IllegalArgumentException("음수를 입력하셨습니다.");
        }
    }

    private static void validateCustomDividerFormat(String input){
        if (input.charAt(1) != '/' || !(input.charAt(3) == '\\' && input.charAt(4) == 'n')) {
            throw new IllegalArgumentException("커스텀 구분자를 올바르게 입력해주세요!");
        }
    }
}
