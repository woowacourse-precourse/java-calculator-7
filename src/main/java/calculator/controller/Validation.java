package calculator.controller;

public class Validation {

    public boolean formValidate(String str) {
        if (str.startsWith("/")) { // custom delimiter
            // 구분자가 두개(문자열)일 수도 있을까?
            if (str.length() >= 4 && !str.startsWith("\\n", 3)) {
                return true;
            } else if (Character.isDigit(str.charAt(2))) {
                return true;
            };
        }
        else { // ,: delimiter
            return !str.isEmpty() && !Character.isDigit(str.charAt(0));
        }
        return false;
    }

    public char findDelimiter(String str) {
        if (str.startsWith("/")) {
            return str.charAt(2);
        } else {
            return ',';
        }
    }
}
