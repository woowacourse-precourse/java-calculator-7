package calculator;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }

        String delimiter = "[,|:]";  // 기본 구분자
        if (input.startsWith("//")) {  // 커스텀 구분자 처리
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);  // 구분자 추출
            input = input.substring(delimiterIndex + 1);  // 숫자 부분만 남김
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
