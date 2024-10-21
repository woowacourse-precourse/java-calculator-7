package separator;

public class StringCalculator {

    public static int add(String inputString) {
        // 입력이 null이거나 공백만 있는 문자열인 경우 0 반환
        if (inputString == null || inputString.trim().isEmpty()) {
            return 0;
        }

        String[] numberTokens = Separator.split(inputString);
        return calculateSum(numberTokens);
    }

    private static int calculateSum(String[] numberTokens) {
        int totalSum = 0;
        for (String numberToken : numberTokens) {
            int number = parsePositiveInt(numberToken);
            totalSum += number;
        }
        return totalSum;
    }

    private static int parsePositiveInt(String numberToken) {
        try {
            int number = Integer.parseInt(numberToken);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다. 사용된 음수: " + numberToken);
            }
            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식: " + numberToken);
        }
    }
}
