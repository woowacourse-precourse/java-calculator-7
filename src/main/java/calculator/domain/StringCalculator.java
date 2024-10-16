package calculator.domain;

public class StringCalculator {

    private final static int INITIAL_NUMBER = 0;
    private final static String EXCEPTION_MINUS_NUMBER = "잘못된 값을 입력하셨습니다.";

    private void validateMinusNumber(int number){
        if(number < INITIAL_NUMBER){
            throw new IllegalArgumentException(EXCEPTION_MINUS_NUMBER);
        }
    }
}
