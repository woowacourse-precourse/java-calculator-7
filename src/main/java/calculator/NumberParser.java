package calculator;

public class NumberParser {
    public int parse(String str) {
        if (!isNumeric(str)) {
            throw new IllegalArgumentException("잘못된 입력입니다: " + str);
        }

        int number = Integer.parseInt(str);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        return number;
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
