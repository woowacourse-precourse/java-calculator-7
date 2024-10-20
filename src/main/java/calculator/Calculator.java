package calculator;

public class Calculator {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0; // 빈 문자열일 경우 0으로 처리
        }

        // 2. 문자열 구분
        String delimiter = ",|:";

        // 2-2. 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }

            // 커스텀 구분자 추출
            String customDelimiter = input.substring(2, delimiterIndex);
            delimiter = customDelimiter;
            input = input.substring(delimiterIndex + 2);
        }

        // 3. 숫자 처리
        String[] numbers = input.split(delimiter);

        // 4. 덧셈
        int sum = 0;
        for (String number : numbers) {
            if (!number.matches("-?\\d+")) {
                throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
            }
            int num = Integer.parseInt(number);

            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += num;
        } // 1,2:3   //;\n1;2;3    1,-2,3

        return sum;
    }
}
