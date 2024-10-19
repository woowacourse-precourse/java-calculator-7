package calculator.utils;

public class Validation {

    public void isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열 입력하지마라 ㅋ");
        }

    }

    public void isOtherStr(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("잘못된 문자열이 속해 있습니다.");
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("잘못된 문자열이 속해 있습니다.");
            }
        }
    }

    public void isCorrectCustomInput(String str) {
        if ((str.startsWith("//") && (!str.contains("\\n"))) ||
                (!str.startsWith("//") && (str.contains("\\n")))) {
            throw new IllegalArgumentException("커스텀 구분자 분리(//, \\n)가 제대로 되어있지 않습니다.");
        }

    }

    public void isNullCustomSplit(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("커스텀 문자열 지정할 시, 커스텀 문자열을 입력해야 합니다. ");
        }
    }
}
