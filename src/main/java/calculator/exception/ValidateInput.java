package calculator.exception;

import calculator.calculator.Input;

import java.util.List;

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

    // 사용자 입력값 검사 - 커스텀 구분자 있는 경우
    public void validateCustomDelimiter(Input input) {
        String inputString = input.getInputString(); // Input 객체 inputString
        List<String> delimiters = input.getDelimiters(); // Input 객체 delimiters

        while (inputString.startsWith("//") || inputString.startsWith("\\n")) {
            int startIndex = 2;
            int endIndex;
            if (inputString.startsWith("//")) {
                endIndex = inputString.indexOf("\\n", startIndex); // "\n" 위치
            } else {
                endIndex = inputString.indexOf("//", startIndex); // "//" 위치
            }

            String customDelimiter = inputString.substring(startIndex, endIndex);
            delimiters.add(customDelimiter);
            inputString = inputString.substring(endIndex + 2);
        }

        input.setInputString(inputString); //구분자 제거한 문자열 저장
        input.setDelimiters(delimiters); // 업데이트된 구분자 리스트 저장
    }
}
