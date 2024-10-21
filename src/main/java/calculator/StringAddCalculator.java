package calculator;

public class StringAddCalculator {
    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|:]";  // 기본 구분자 쉼표와 콜론

        // 커스텀 구분자 처리
        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\n");
            delimiter = text.substring(2, delimiterIndex);
            text = text.substring(delimiterIndex + 1);
        }

        // 구분자를 사용해 문자열 분리
        String[] tokens = text.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
