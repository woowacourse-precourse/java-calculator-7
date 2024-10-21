package calculator;

public class Check {
    public String check_last_char(String str) {
        if (str.charAt(str.length() - 1) >= '0' && str.charAt(str.length() - 1) <= '9') {
            str += ",";
        }
        return str;
    }

    public char check_custom(String str) {
        if (str.length() >= 5 && str.charAt(0) == '/' && str.charAt(1) == '/' && str.charAt(3) == '\\' && str.charAt(4) == 'n') {
            return str.charAt(2);
        }
        return '\0';
    }
}
