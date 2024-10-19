package calculator;


public class CustomDelimiter {
    protected static String result = "";
    protected static char customDelimiter = '0';
    private static final int lengthOfCustomDelimiterExpression = "//?\n".length();
    private static final int indexOfCustomDelimiter = "//?\n".indexOf("?");

    public static String extractCustomDelimiter(String input) {
        if (isValidExpression(input)) {
            customDelimiter = input.charAt(indexOfCustomDelimiter);
            return result= input.substring(lengthOfCustomDelimiterExpression);
        }

        if (Character.isDigit(customDelimiter)){
            throw new IllegalArgumentException("커스텀 구분자로 숫자가 입력되었습니다.");
        }

        // 실제 커스텀 구분자 처리 로직은 추후 구현
        return result;
    }


    public static boolean isValidExpression(String input) {
        if(input.contains("\\")) {
            return isValidExpressionWhileContainEscapeCaracter(input);
        }

        if (!isValidExpressionLength(input)) {
            throw new IllegalArgumentException("커스텀 구분자 표현이 잘못되었습니다.");
        }

        return true;

    }



    private static boolean isValidExpressionWhileContainEscapeCaracter(String input) {
        if(input.startsWith("//\\")) {
            customDelimiter = input.charAt(indexOfCustomDelimiter);
            result = input.substring(indexOfCustomDelimiter+1);
            return true;
        }
        return false;
    }

    private static boolean isValidExpressionLength(String input) {
        return input.substring(0, input.indexOf("\n")+1).length() == lengthOfCustomDelimiterExpression;
    }

}
