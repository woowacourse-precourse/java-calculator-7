package calculator;
public class NumberParser {
    // 입력 문자열을 구분자로 분리하여 숫자로 변환하는 메서드
    public static int[] parse(String input, String delimiter) {
        if (input.trim().isEmpty()) {
            return new int[0]; // 입력이 비어있으면 빈 배열 반환
        }

        String[] tokens = input.split(delimiter); // 구분자로 숫자를 분리
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();
            if (token.isEmpty()) {
                continue; // 빈 토큰은 건너뜀
            }

            try {
                numbers[i] = toPositiveInteger(token); // 각 토큰을 숫자로 변환
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(); // "유효하지 않은 숫자 형식: " + token
            }
        }

        return numbers;
    }



    // 문자열을 정수로 변환하고 음수일 경우 예외 발생
    private static int toPositiveInteger(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new IllegalArgumentException(); // "음수는 입력할 수 없습니다: " + number
        }
        return number;
    }
}
