package calculator;

public class StringAddCalculator {
    public static int split(String input) {
        int result = 0;

        String delimiter = ",|:";

        // 공백인 경우 return
        if (input.isEmpty()) {
            return 0;
        }

        int startDelimiter = input.indexOf("//");
        int endDelimiter = input.indexOf("\\n");

        // 입력된 구분자가 있는지 탐색
        if (startDelimiter == 0 && endDelimiter == 3) {
            // 있는 경우, 기존 구분자 케이스에 추가
            delimiter += "|" + input.charAt(2);
            // 구분자 범위를 제외하고 숫자에 해당하는 부분만 추출하여 연산
            input = input.substring(endDelimiter + 2, input.length());
        }

        String[] parts = input.split(delimiter);
        for (String part : parts) {
            result += Integer.parseInt(part);
        }

        return result;
    }
}
