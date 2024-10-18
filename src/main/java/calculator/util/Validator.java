package calculator.util;

import calculator.domain.Calculator;

import java.util.regex.Pattern;

public class Validator {


    public void validateNumber(String strNumber) {
        try{
            int number = Integer.parseInt(strNumber);
            if(number <= 0){
                throw new IllegalArgumentException("숫자는 양수이어야 합니다. 입력 받은 숫자: " + number);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("올바르지 않은 숫자 형식입니다. 입력 받은 숫자: " + strNumber);
        }
    }

    public void validateStartOfRegister(String startOfRegister) {
        if(!startOfRegister.equals("//")){
            throw new IllegalArgumentException("구분자 등록은 \"//\"으로 시작되어야 합니다. 입력 받은 문자열: " + startOfRegister);
        }
    }

    public void validateEndOfRegister(String endOfRegister) {
        if(!endOfRegister.equals("\\n")){
            throw new IllegalArgumentException("구분자 등록은 \"\\n\"으로 끝나야 합니다. 입력 받은 문자열: " + endOfRegister);
        }
    }

    public void validateRegisteredSeperator(Calculator calculator, String seperator) {
        if(!calculator.getSeperators().contains(seperator)){
            throw new IllegalArgumentException("등록되지 않은 구분자입니다. 입력 받은 구분자: " + seperator);
        }
    }

    public void validateNewSeperator(String newSeperator) {
        String regex = "[0-9]+";

        if(Pattern.matches(regex, newSeperator)){
            throw new IllegalArgumentException("구분자로 숫자를 등록할 수 없습니다. 입력 받은 구분자: " + newSeperator);
        }
    }
}
