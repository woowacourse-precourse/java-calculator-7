package calculator;

public class StringCalculator {
    public int add(String input) {
        // 입력값이 빈 문자열이거나 null인 경우 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 쉼표와 콜론을 기준으로 문자열 분리
        String[] numbers = input.split(",:");

        // 숫자 합산
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        // 결과 출력
        return sum;
    }

}
