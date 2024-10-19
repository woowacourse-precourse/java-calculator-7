package calculator.model;

import java.util.Arrays;

/**
 * 사용자로부터 입력받은 문자열 관리 model
 */
public class InputString {

    private String inputString;             // 문자열
    private long resultSum;                 // 문자열에서 추출한 숫자들을 더한 결과
    private String customDelimiter;         // 커스텀 구분자

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    //== 비즈니스 로직 ==//

    /**
     * 문자열에서 숫자를 추출해서 덧셈한다.
     *
     * @return resultSum 덧셈 계산 결과값
     */
    public long calculate() {
        getCustomDelimiter();

        String delimiters = this.customDelimiter == null ? ",|:" : customDelimiter + "|,|:";

        long[] numberList = splitStringByDelimiters(delimiters);

        return this.resultSum;
    }

    /**
     * 문자열에서 커스텀 구분자 추출
     */
    private void getCustomDelimiter() {
        if (inputString.startsWith("//") && inputString.substring(3, 5).equals("\\n")) {
            this.customDelimiter = inputString.substring(2, 3);
            this.inputString = inputString.substring(5);
        }
    }

    /**
     * 문자열에서 숫자 추출
     *
     * @param delimiters 구분자(쉼표 (,)또는 콜론(:)또는 커스텀 구분자)
     * @return 문자열에서 추출한 숫자 리스트
     */
    private long[] splitStringByDelimiters(String delimiters) {
        String[] numbersInString = this.inputString.split(delimiters);

        return Arrays.stream(numbersInString)
                .mapToLong(Long::parseLong)
                .toArray();
    }

}
