package calculator;

public class Calculator {

    // 문자열 덧셈 계산 로직
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        String delimiter = ",|:"; // 기본 구분자 쉼표와 콜론

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");

            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다. 올바른 형식이 아닙니다.");
            }

            // 커스텀 구분자를 "//" 뒤부터 "\n" 전까지 추출
            delimiter = input.substring(2, delimiterEndIndex);

            // "\n" 이후 부분만 추출
            input = input.substring(delimiterEndIndex + 1);
        }

        // 입력 문자열을 구분자로 분리
        String[] numbers = input.split(delimiter);

        return sumNumbers(numbers);
    }

    // 문자열 배열로부터 숫자를 추출하여 더하는 메소드
    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parsePositiveInteger(number); // 양수 여부 확인
            sum += num;
        }
        return sum;
    }

    // 문자열을 양수로 변환, 유효성 검사
    private int parsePositiveInteger(String number) {
        try {
            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력: " + number);
        }
    }
}
