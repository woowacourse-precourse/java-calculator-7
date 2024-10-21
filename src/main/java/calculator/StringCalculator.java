package calculator;

public class StringCalculator {
    public int add(String input, String delimiter) {
        // 입력값이 빈 문자열이거나 null인 경우 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        System.out.println("사용할 구분자: " + delimiter); // 디버깅

        String[] numbers = input.split(delimiter);

        // 숫자 합산
        int sum = 0;
        for (String number : numbers) {
            // 문자열에 포함된 공백 제거
            number = number.trim();

            if (number.isEmpty()) {
                continue;
            }

            int num;

            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식의 숫자입니다.");
            }

            // 음수 예외 처리
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num;
        }

        // 결과 출력
        return sum;
    }

}