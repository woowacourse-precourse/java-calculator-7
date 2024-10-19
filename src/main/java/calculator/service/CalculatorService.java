package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    /**
     * 문자열 입력값을 확인후 합산하여 반환하는 메서드
     *
     * @param input
     * @return
     */
    public int caculate(String input) {
        if (input == null || input.isEmpty()) { // 입력값이 null 혹은 비어있다면
            return 0;   // 0을 반환한다.
        }

        String delimiter = ",|:"; // 기본 구분자
        // 커스텀 구분자
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input); //와 \n 사이에 있는 구분자로 입력 문자열을 나눈다.
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            }
        }

        String[] numbers = input.split(delimiter); // 입력값을 구분자로 나누어 String형 배열에 저장
        return calculateSum(numbers); // 합산 메서드 호출
    }//calculate

    /**
     * 문자열 배열 안의 숫자를 정수형 변환후 합산하는 메서드
     *
     * @param numbers
     * @return
     */
    private int calculateSum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            number = number.trim(); // 양쪽 공백 제거
            total += validateNumber(number); // 숫자 유효성 검사를 통해 합산
        }
        return total; // 최종 합계 반환
    }//calculateSum

    /**
     * 문자열 유효성 검사 메서드 success : 정수형 숫자를 return fail : IllegalArgumentException()을 발생한다.
     *
     * @param number
     * @return
     */
    private int validateNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) { // 숫자가 음수라면
                throw new IllegalArgumentException();
            }
            return num;
        } catch (NumberFormatException nfe) { // 숫자가 아닌 문자열을 정수형으로 바꾸면 예외가 발생한다.
            throw new IllegalArgumentException();
        }
    }
}
