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

        validateInputString(this.inputString);

        long[] numberList = getNumbers(combineDelimiters());

        sum(numberList);

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
     * 문자열 검증 (숫자, 구분자 외의 다른 값은 입력할 수 없다.)
     */
    private void validateInputString(String inputString) {
        String delimiters = combineDelimiters();

        String invalidCharsRegex = "[^[0-9]" + delimiters + "]";

        if (inputString.matches(".*" + invalidCharsRegex + ".*")) {
            throw new IllegalArgumentException("입력은 양수와 구분자만을 포함해야 합니다.");
        }
    }

    /**
     * split을 위한 구분자 리스트 생성
     */
    private String combineDelimiters() {
        if (this.customDelimiter == null) {
            return ",|:";
        }
        if (this.customDelimiter.equals("|")) {
            return "\\|" + "|,|:";
        }
        return customDelimiter + "|,|:";
    }

    /**
     * 문자열에서 숫자 추출
     *
     * @param delimiters 구분자(쉼표 (,)또는 콜론(:)또는 커스텀 구분자)
     * @return 문자열에서 추출한 숫자 리스트
     */
    private long[] getNumbers(String delimiters) {

        String[] numbersInString = this.inputString.split(delimiters);

        return Arrays.stream(numbersInString)
                .filter(s -> !s.isEmpty())
                .mapToLong(Long::parseLong)
                .toArray();
    }

    /**
     * 덧셈 계산
     *
     * @param numberList 문자열로부터 추출한 숫자들
     */
    private void sum(long[] numberList) {
        for (long number : numberList) {
            resultSum += number;
        }
    }
}
