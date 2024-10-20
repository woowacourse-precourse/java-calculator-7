package calculator;


public class CustomDelimiter {
    protected static String result = "";
    protected static String customDelimiter = "";
    private static final int lengthOfCustomDelimiterExpression = "//?\n".length();
    private static final int indexOfCustomDelimiter = "//?\n".indexOf("?");
    private static final String[] metaCharacters = {".", "*", "+", "?", "|", "^", "$", "(", ")", "[", "]", "{", "}" ,"\\"};

    public static String extractCustomDelimiter(String input) {
        if (isValidExpression(input)) {
            customDelimiter = input.substring(2, 3);

            customDelimiter = escapeMetaCharacters(customDelimiter);
            result = input.substring(lengthOfCustomDelimiterExpression+1);
            return result;
        }

        if (Character.isDigit(Integer.parseInt(customDelimiter))){
            throw new IllegalArgumentException("커스텀 구분자로 숫자가 입력되었습니다.");
        }

        return result;
    }




    public static boolean isValidExpression(String input) {
        if(input.contains("\\n")) {
            return true;
        }

        if (!isValidExpressionLength(input)) {
            throw new IllegalArgumentException("커스텀 구분자 표현이 잘못되었습니다.");
        }

        throw new IllegalArgumentException();

    }

//    private static boolean isValidExpressionWhileContainCaracter(String input) {
//    }


    private static boolean isValidExpressionWhileContainEscapeCaracter(String input) {
        if(input.startsWith("//\\")) {
            customDelimiter = String.valueOf(input.charAt(indexOfCustomDelimiter));
            result = input.substring(indexOfCustomDelimiter+1);
            return true;
        }
        return false;
    }

    private static boolean isValidExpressionLength(String input) {
        return input.substring(0, input.indexOf("\n")+1).length() == lengthOfCustomDelimiterExpression;
    }

    private static String escapeMetaCharacters(String customDelimiter) {
        for (String metaChar : metaCharacters) {
            if (customDelimiter.equals(metaChar)) {
                return "\\" + customDelimiter;  // 메타 문자가 있다면 이스케이프 처리
            }
        }
        return customDelimiter;
    }

}
