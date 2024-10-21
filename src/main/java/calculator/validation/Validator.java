package calculator.validation;

public class Validator {

    private static String inputFormatCheck = "(\\/\\/[^\\d]{1,}\\\\n)?((\\d{1,}.{0,}\\d$)|\\d|^$)";

    public static void checkInput( String inputStr ) {
        if ( !inputStr.matches( inputFormatCheck ) )
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static void checkSumExpValidity( String sumExp, String divider_regex ) {
        for ( String expChar: sumExp.replaceAll("\\d", "").split("") ) {
            if ( expChar.isEmpty() ) continue;
            if ( !expChar.matches( divider_regex ) )
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
