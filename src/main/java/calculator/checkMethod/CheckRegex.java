package calculator.checkMethod;

public class CheckRegex {

    private static final String[] REGEX_ARR = new String[]{"\\.", "\\?", "\\$", "\\{", "\\}", "\\(", "\\)", "\\+", "\\[", "\\]", "\\^", "\\*"};

    public static String checkRegex(String input){
        for (String regex : REGEX_ARR) {
            input = input.replaceAll(regex, "\\" + regex);
        }

        return input;
    }

}
