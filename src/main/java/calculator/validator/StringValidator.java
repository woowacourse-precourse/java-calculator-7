package calculator.validator;

public class StringValidator{
    public static String getValidatedInput(String input){
        return isEmptyInput(input) ? "0" : input;
    }

    public static Boolean isEmptyInput(String input){
        return input.isEmpty();
    }

    public static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }
}
