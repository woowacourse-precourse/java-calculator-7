package calculator.model;

public class RegDelimiter {
    public boolean includesCustomDelimiter(String value) {
        if (value.length() >= 2) {
            if (value.charAt(0) == '/' && value.charAt(1) == '/') {
                return true;
            }
        }
        return false;
    }
}
