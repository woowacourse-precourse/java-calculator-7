package calculator;

public class StringAddCalculator {
    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        // 쉼표와 콜론을 구분자로 사용해 문자열을 분리
        String[] tokens = text.split("[,|:]");
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}