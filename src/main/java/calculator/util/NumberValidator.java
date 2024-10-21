package calculator.util;

public class NumberValidator {


    /**
     * 주어진 문자열이 유효한 양의 정수인지 검증
     * <p>
     * 검증 : 1. 입력된 문자열이 정수로 변환 가능한지 2. 변환된 정수가 양수인지
     *
     * @param number 검증할 숫자 문자열
     * @throws IllegalArgumentException 다음의 경우에 발생: 입력된 문자열이 정수로 변환할 수 없는 경우, 변환된 정수가 0 이하인 경우
     */
    public void validate(String number) {
        System.out.println("NumberValidator - 검증 대상 숫자: " + number);
        try {
            int value = Integer.parseInt(number.trim());
            if (value <= 0) {
                // 들어온 값이 음수라면 사용자 입력 오류 발생
                throw new IllegalArgumentException("음수 입력");
            }
        } catch (NumberFormatException e) {
            //변환하는 값이 숫자가 아니라면? 오류 발생
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
        }
    }
}