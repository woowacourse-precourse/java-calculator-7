package calculator.validate;

import calculator.errorMessage.CustomException;
import calculator.errorMessage.ErrorMessage;

public class Validator {

    /**
     * 문자열 숫자를 정수변환 해주는 메서드
     * @param token 문자열 숫자
     * @return 정수로 변환된 숫자
     */
    public static int validate(String token){
        try{
            int number = Integer.parseInt(token);
            if(number <= 0){
                throw new CustomException(ErrorMessage.NEGATIVE_NUMBER);
            }
            return number;
        } catch(NumberFormatException e){
            throw new CustomException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    /**
     * 커스텀 구분자를 지정해주는 // \n의 형식이 잘못된지 검증 해주는 메서드
     * @param index \n의 위치 값
     */
    public static void checkCustomDelimiter(int index){
        if(index == -1 ){
            throw new CustomException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
        }
    }

    /**
     * 커스텀 구분자에 숫자가 포함되어 있으면 예외를 발생 시켜주는 메서드
     * @param delimiter 구분자
     */
    public static void containsNumber(String delimiter){
        if(delimiter.matches(".*\\d.*")){
            throw new CustomException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
        }
    }
}
