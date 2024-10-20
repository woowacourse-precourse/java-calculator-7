package calculator;

public class ValueCheck {
    public static int[] checkValue(String[] textValues) {
        int[] values = new int[textValues.length];
        for (int i = 0; i < textValues.length; i++) {
            try {
                int parseIntVal = Integer.parseInt(textValues[i].trim());
                if (parseIntVal <= 0) {
                    throw new IllegalArgumentException("양수의 정수를 입력하셔야 합니다. 확인 후 다시 입력해주세요.");
                } else {
                    values[i] = parseIntVal;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 문자 또는 빈칸을 같이 입력하셨습니다. 확인 후 다시 입력해주세요.");
            }
        }
        return values;
    }
}
