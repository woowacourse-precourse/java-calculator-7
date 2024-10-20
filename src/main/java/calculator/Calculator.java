package calculator;

public class Calculator {
    public int calculate(String input) {
        if (input.trim().isEmpty() || input == null) {
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
            sum += parsePositiveNumber(number);
        } // 1,2:3   //;\n1;2;3

        return sum;
    }

    private int parsePositiveNumber(String number) {
        if (number.trim().isEmpty()) {
            return 0; // 빈 문자열일 경우 0으로 처리
        }

        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }
}
