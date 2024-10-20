package calculator.validator;

import java.util.List;

public class InputValidator implements Validator{

    @Override
    public boolean hasNegativeValue(List<Integer> list) {
        for (Integer i : list) {
            if(i < 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean customDelimiterContains(String input) {
        return input.startsWith("//");
    }

    @Override
    public boolean isSpecialDelimiter(String string) {
        if (string.equals("\"") || string.equals("\'") || string.equals("\\") || string.equals("(") ||
                string.equals(")") || string.equals("[") || string.equals("]") || string.equals("}") ||
                string.equals("{") || string.equals("?") || string.equals("*") || string.equals("|")) {
            return true;
        }

        return false;
    }
}
