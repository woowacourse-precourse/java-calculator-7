package calculator;

public class StringAddCalculator {
    public static <T extends Number> T split(String input) throws IllegalArgumentException {
        double result = 0;

        String delimiter = ",|:";

        // 공백인 경우 return
        if (input.isEmpty()) {
            return (T) Integer.valueOf(0);
        }

        int startDelimiter = input.indexOf("//");
        int endDelimiter = input.indexOf("\\n");

        // 입력된 구분자가 있는지 탐색
        if (startDelimiter == 0 && endDelimiter == 3) {
            // 있는 경우, 기존 구분자 케이스에 추가
            char customDelimiter = input.charAt(2);

            if (customDelimiter == '+' ||
                customDelimiter == '-' ||
                customDelimiter == '*' ||
                customDelimiter == '/') {
                delimiter += "|\\" + customDelimiter;
            } else {
                delimiter += "|" + customDelimiter;
            }

            // 구분자 범위를 제외하고 숫자에 해당하는 부분만 추출하여 연산
            input = input.substring(endDelimiter + 2, input.length());
        }

        String[] parts = input.split(delimiter);
        if (parts.length <= 1 && input.length() >= 2) {
            throw new IllegalArgumentException("구분자가 잘못되었습니다.");
        }

        for (String part : parts) {
            double target = Double.parseDouble(part);
            if (target > 0) {
                result += target;
            } else {
                throw new IllegalArgumentException("양수 외 수는 입력할 수 없습니다.");
            }
        }

        if (result == (int) result) {
            return (T) Integer.valueOf((int) result);
        } else {
            return (T) Double.valueOf(result);
        }
    }
}
