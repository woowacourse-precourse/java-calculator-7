package calculator.validation;

public class Validator {
    /**
     * 입력형식 체크를 위한 정규식
     */
    private static String inputFormatCheck = "(\\/\\/[^\\d]{1,}\\\\n)?((\\d{1,}.{0,}\\d$)|\\d|^$)";

    /**
     * 주어진 인자가 입력형식과 일치하는지 확인합니다.
     * @param inputStr 사용자에게 입력받은 문자열
     * @throws IllegalArgumentException 정규식 형식과 일치하지 않는 경우
     */
    public static void checkInput( String inputStr ) {
        if ( !inputStr.matches( inputFormatCheck ) )
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    /**
     * 숫자가 담겨있는 수식표현영역에서 비정상적인 구분자가 사용되었는지 확인합니다.
     * @param sumExp 수식표현영역 문자열
     * @param divider_regex 커스텀구분자를 포함한 구분자 분류 정규식
     * @throws IllegalArgumentException 수식표현영역에서 구분자분류정규식에 부합하지 않는 구분자가 포함된 경우
     */
    public static void checkSumExpValidity( String sumExp, String divider_regex ) {
        for ( String expChar: sumExp.replaceAll("\\d", "").split("") ) {
            if ( expChar.isEmpty() ) continue;
            if ( !expChar.matches( divider_regex ) )
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
