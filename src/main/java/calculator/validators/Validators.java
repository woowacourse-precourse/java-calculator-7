package calculator.validators;

public class Validators {

    public static boolean validateDelimiterDeclaration(String s) {
        if (s.startsWith("//")) {
            if (!s.contains("\\n")) {
                throw new IllegalArgumentException();
            }
            return true;
        }
        return false;
    }
}
