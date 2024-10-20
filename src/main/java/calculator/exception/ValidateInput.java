package calculator.exception;

import calculator.calculator.Input;

public class ValidateInput {

    //사용자 입력값 검사 - 커스텀 구분자 없는 경우
    public void validateDefaultDelimiter(Input input) {
        //기본 구분자(",", ":")와 양수만 허용하는 정규식 (빈 문자열도 허용함)
        String regex = "^[0-9]*([,:][0-9]*)*$";

        //정규식과 일치하지 않을 때 IllegalArgumentException
        if (!input.getInputString().matches(regex)) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 기본 구분자는 쉼표와 콜론만 가능하고, 숫자는 양수만 입력할 수 있습니다.");
        }

    }
}
