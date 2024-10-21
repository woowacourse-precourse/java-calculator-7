package calculator;

public class StringCalculator {

    public static int add(String input) {

        //문자열 구분
        // 빈 문자열 또는 null 입력 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 (쉼표와 콜론)
        String numbers = input;

        if (input.endsWith(",") || input.endsWith(":")) {
            throw new IllegalArgumentException("구분자 뒤에 숫자가 없습니다.");
        }

        // 커스텀 구분자가 있는 경우 처리
        if (input.startsWith("//")) {
            String[] result = extractCustomDelimiter(input);
            delimiter = result[0];
            numbers = result[1];
        }

        // 구분자를 기준으로 숫자를 분리
        return calculate(numbers, delimiter);

    }

    private static int calculate(String numbers, String delimiter) {
        String[] tokens = numbers.split(delimiter);

        int sum = 0;

        // 앞이나 중간에 빈 값이 있으면 에러 발생
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("잘못된 형식: 숫자가 누락되었습니다.");
            }
        }

        try {
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    int number = Integer.parseInt(token);
                    if (number < 0) {
                        throw new IllegalArgumentException();
                    }
                    sum += number;  // 각 숫자를 더함
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }

        return sum;
    }

    // 커스텀 구분자를 추출하는 static 메서드
    private static String[] extractCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String delimiter = input.substring(2, delimiterIndex);

        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자 문자여야합니다.");
        }

        if (input.endsWith(delimiter)) {
            throw new IllegalArgumentException("구분자 뒤에 숫자가 없습니다.");
        }

        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 비어있습니다.");
        }

        String numbers = input.substring(delimiterIndex + 2);

        return new String[]{delimiter, numbers};
    }

}
