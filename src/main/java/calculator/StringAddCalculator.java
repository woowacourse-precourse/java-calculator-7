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

    private int StringToInt(String value) {
        return Integer.parseInt(value);
    }

    private int calculateSum(String[] values) {
        int sum = 0;
        for (String value : values) {
            if (StringToInt(value) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += StringToInt(value);
        }
        return sum;
    }

    private String findStandardDelimiter() {
        return ",|:";
    }

    private String[] extractNumbersForStandard(String input) {
        return input.split(findStandardDelimiter());
    }

    private String findCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            int index = input.indexOf("\n");
            if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 없습니다.");
            }
            String customDelimiter = input.substring(2, index);
            return customDelimiter;
        }
        throw new IllegalArgumentException("커스텀 구분자가 없습니다.");
    }

}
