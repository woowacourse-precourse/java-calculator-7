package calculator.validation;

public class IOValidation {
    private static String inputFormatCheck = "((\\d.){0,}(\\d)|^$)";

    public static void checkInput( String inputStr ) {
        if ( !inputStr.matches( inputFormatCheck ) )
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
