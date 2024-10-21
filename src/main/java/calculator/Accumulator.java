package calculator;

/**
 * 문자열 배열을 받아 각 문자열을 정수로 변환한 후, 변환된 정수들의 합을 구하는 클래스
 */
public class Accumulator {

    /**
     * 입력받은 문자열 배열을 정수로 변환하고 그 합을 구함
     *
     * @param input 정수로 변환할 문자열 배열
     * @return 변환된 정수들의 합
     */
    public int sum(String[] input) {
        int sum = 0;  // 합을 저장할 변수

        for (String s : input) {
            // 빈 문자열일 경우 0을 더하고 다음 루프로 넘어감
            if (s.isEmpty()) {
                sum += 0;
                continue;
            }

            // 숫자가 아닌 입력에 대한 예외 처리
            ExceptionHandler.handleNonNumbericInput(s);

            // 숫자가 int 범위를 벗어나는지 확인
            ExceptionHandler.handleNumberRange(s);

            // 문자열을 정수로 변환하여 합계에 더함
            int number = Integer.parseInt(s);
            sum += number;
        }

        return sum;
    }
}
