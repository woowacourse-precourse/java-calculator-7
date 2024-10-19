package calculator.checkMethod;

public class CheckRegex {

    private static final String[] regex = new String[]{"\\.", "\\?", "\\$", "\\{", "\\}", "\\(", "\\)", "\\+", "\\[", "\\]", "\\^", "\\*"};

    public static String checkRegex(String input){
        for (String r : regex) {
            input = input.replaceAll(r, "\\" + r);
        }

        return input;
    }

}
