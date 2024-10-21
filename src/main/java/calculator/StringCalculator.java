package calculator;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Delimiter delimiter = new Delimiter(input);
        StringParser parser = new StringParser(delimiter);

        // 커스텀 구분자가 있을 때 실제 숫자 부분만 파싱
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            input = input.substring(newlineIndex + 1); // 커스텀 구분자 이후 숫자 부분
        }

        String[] numbers = parser.parse(input);

        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) continue; // 빈 값 건너뛰기
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
