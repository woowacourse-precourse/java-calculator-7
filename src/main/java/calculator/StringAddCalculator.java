package calculator;

public class StringAddCalculator {

    public int Calculator(String input) {
        //입력값이 없을 경우 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }
        //입력값이 1개일 경우
        if (input.length() == 1) {
            if (!Character.isDigit(input.charAt(0))) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            return StringToInt(input);
        }
        String[] values;
        if (input.startsWith("//")) {
            values = extractNumbersForCustom(input);
        } else {
            values = extractNumbersForStandard(input);
        }
        return calculateSum(values);
    }
}
