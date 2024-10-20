package calculator.validator;

public class InputValidator {

    // parseInt 후 값 검증(양수만 허용)
    public static int validateParseInt(String token){
        int number = 0;
        if(!token.isEmpty()){
            try{
                number = Integer.parseInt(token);

                // 양수만 허용
                if(number <= 0){
                    throw new IllegalArgumentException("입력된 숫자는 0보다 커야 합니다.");
                }

            } catch (NumberFormatException e){ // 숫자가 아닌 값
                throw new IllegalArgumentException("입력된 값이 숫자 형식이 아닙니다.");
            }
        }

        // 숫자로 변환한 값 반환(빈 문자열일 경우 0)
        return number;
    }

    // 커스텀 구분자 지정 형식 확인
    public static void validateFormat(int delimiterEndIdx){
        if(delimiterEndIdx == -1){
            throw new IllegalArgumentException("커스텀 구분자 지정 형식이 잘못되었습니다.");
        }
    }

    // 커스텀 구분자 유효성 확인
    public static void validateDelimiter(String customDelimiter){
        if(customDelimiter == null || customDelimiter.length() != 1){
            throw new IllegalArgumentException("커스텀 구분자는 하나의 문자여야 합니다.");
        }

        // 구분자가 숫자인 경우 예외 발생
        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }
}
