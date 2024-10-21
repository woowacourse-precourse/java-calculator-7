package calculator;

public class SumCalculator {
    public static int add(String input) {

        if (input.isEmpty()) {
            return 0;
        }

        String customDelimiter = ",";
        String numbersPart = input;

        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n", 2);
            customDelimiter = parts[0].substring(2);
            numbersPart = parts[1];
        }

        // 특수 문자를 정규식에서 올바르게 처리하기 위해 이스케이프 처리
        String escapedDelimiter = customDelimiter.replaceAll("([\\W])", "\\\\$1");
        String regex = "[" + escapedDelimiter + ",:]"; // 기본 구분자와 결합
        String[] tokens = numbersPart.split(regex);

        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                sum += Integer.parseInt(token);
            }
        }
        return sum;
    }
}