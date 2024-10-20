package calculator.domain;

public class Calculator {

    // 기본 생성자
    public Calculator() {
    }

    // 숫자 배열을 받아서 각각 더한 결과를 반환하는 메서드
    public int add(String[] numbers) {
        int sum = 0;  // 총합을 저장할 변수

        // 숫자 배열을 반복하면서 각 숫자를 더함
        for (String number : numbers) {
            sum += this.toPositiveInt(number);  // 양수로 변환한 후 더함
        }

        return sum;  // 최종 합계 반환
    }

    // 문자열을 양의 정수로 변환하는 메서드
    private int toPositiveInt(String number) {
        int num = this.parseInt(number);  // 문자열을 정수로 변환
        this.validateNonNegative(num);    // 음수인지 확인
        return num;  // 양수면 그대로 반환
    }

    // 문자열을 정수로 변환하는 메서드
    private int parseInt(String number) {
        // 문자열이 null이 아니고 비어있지 않은지 확인
        if (number != null && !number.trim().isEmpty()) {
            try {
                // 문자열을 정수로 변환
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                // 숫자가 아닌 값이 입력되었을 때 예외 처리
                throw new IllegalArgumentException("유효한 숫자가 아닙니다: " + number);
            }
        } else {
            // 빈 문자열에 대한 예외 처리
            throw new IllegalArgumentException("유효한 숫자가 아닙니다: 빈 문자열");
        }
    }

    // 음수 값이 입력되었는지 확인하는 메서드
    private void validateNonNegative(int num) {
        if (num < 0) {
            // 음수일 경우 예외 처리
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
    }
}