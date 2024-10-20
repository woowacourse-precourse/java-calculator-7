package calculator;

public class StringCalculator {

    // 입력값 받아 덧셈 결과 반환
    public static int add(String input) {
        // 입력값이 null이거나 비어있으면 0 리턴
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 입력값 앞뒤 공백 제거
        input = input.trim();
        // 공백만 있으면 0 리턴
        if (input.isEmpty()) {
            return 0;
        }

        // 입력된 문자열을 구분자로 나누고 tokens 배열에 저장
        String[] tokens = Delimiter.split(input);
        // 배열 내부 값을 더해서 리턴
        return sum(tokens);
    }

    // 문자열 배열을 받아서 덧셈 결과 반환
    private static int sum(String[] tokens) {
        int sum = 0;
        // 배열의 각 요소들에 대해 반복하며 공백 제거하고 검증 수행
        for (String token : tokens) {
            token = token.trim();
            InputValidator.validateNumber(token);
            // 문자열 정수로 변환 후 합산
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}