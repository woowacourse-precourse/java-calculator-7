package calculator;

public class StringSplitter {

    public String[] splitString(String input, String delimiter) {
        String[] parts = input.split(delimiter, -1);
        for (int i = 0; i < parts.length; i++) {
            if (isValidZero(parts[i])) {
                parts[i] = "0";
            }
            isNegativeNumber(parts[i]);
        }
        return parts;
    }

    private boolean isValidZero(String part) {
        return part == null || part.isEmpty();
    }

    public void isNegativeNumber(String number) {
        if (number.charAt(0) == '-') {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
    }
}
