package calculator;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex);  // 커스텀 구분자 설정
            input = input.substring(delimiterEndIndex + 1);  // 숫자 부분 추출
        }

        String[] tokens = input.split(delimiter);  // 구분자로 문자열을 나눔
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {  // 빈 문자열이 아닌 경우에만 처리
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                }
                sum += number;
            }
        }
        return sum;
    }
}
