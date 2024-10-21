package calculator;

public class Check {
    public String check_last_char(String str) {
        if (str.charAt(str.length() - 1) >= '0' && str.charAt(str.length() - 1) <= '9') {
            str += ",";
        }
        return str;
    }

    public char check_custom(String str) {
        if (str.startsWith("//") && str.substring(3).startsWith("\\n")
        ) {
            return str.charAt(2);
        }
        return '\0';
    }
}
