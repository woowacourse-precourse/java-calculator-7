package calculator;

public class InputValidator {
    public char[] validate(String s) {
        char[] defaultDelimiters= new char[]{',', ';'};
        if (s.isEmpty()) {
            return defaultDelimiters;
        }

        if (!s.startsWith("//") && validateHelper(s, defaultDelimiters)) {
            return defaultDelimiters;
        }
        if (s.length() >= 4 && s.substring(0,4).matches("//.\\n")) {
            String sub = s.substring(4);
            validateHelper(sub, new char[]{',', ';', s.charAt(2)});
            return new char[]{',', ';', s.charAt(2)};
        }
        throw new IllegalArgumentException();
    }

    private boolean validateHelper(String s, char[] delimiters) {
        char[] parsed = s.toCharArray();
        for (int i=0; i < parsed.length; i++) {
            if (48 <= parsed[i] && parsed[i] <= 57) {
                continue;
            }
            boolean isChecked = false;
            for (char token: delimiters) {
                if (parsed[i] == token) {
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                continue;
            }
            throw new IllegalArgumentException();
        }
        return true;
    }
}
