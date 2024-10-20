package calculator;

/** 구분자를 관리하는 클래스. 커스텀 구분자 지정 시, 예외 처리와 커스텀 구분자 저장을 담당합니다. */
public class DelimiterManager {

    /**
     * MAX_CUSTOM_DELIMITERS: 커스텀 구분자를 포함한 구분자 문자열의 최대 길이
     * delimiters: 구분자 문자열
     * count: 현재 구분자 문자열의 길이
     */
    private static final int MAX_CUSTOM_DELIMITERS = 3;
    private String delimiters;
    private int count;

    public DelimiterManager() {
        delimiters = ",:";
        count = 2;
    }

    /**
     * 기존의 구분자 문자열에 커스텀 구분자를 더하고 구분자 개수를 1 증가 시킵니다.
     *
     * @param delimiter 기존의 구분자 문자열에 추가할 새로운 커스텀 구분자
     */
    public void addDelimiter(String delimiter) {

        isDelimiterLimitExceeded();
        isDelimiterExists(delimiter);

        delimiters += delimiter;
        count++;
    }

    /**
     * 구분자의 최대 개수를 초과하는지 확인합니다.
     *
     * @throws IllegalArgumentException 커스텀 구분자의 개수는 1개를 초과할 수 없습니다.
     */
    private void isDelimiterLimitExceeded() {
        if (count >= MAX_CUSTOM_DELIMITERS) {
            throw new IllegalArgumentException("Only one custom delimiter is allowed.");
        }
    }

    /**
     * 매개변수로 전달받은 구분자가 이미 존재하는 구분자와 같은지 확인합니다.
     *
     * @param customDelimiter 입력받은 커스텀 구분자
     * @throws IllegalArgumentException 기존의 구분자(",", ":")와 동일한 구분자는 커스텀 구분자가 될 수 없습니다.
     */
    private void isDelimiterExists(String customDelimiter) {
        if (delimiters.contains(customDelimiter)) {
            throw new IllegalArgumentException("Custom delimiter cannot be a default delimiter (',' or ':').");
        }
    }

    /**
     * 해당 문자가 구분자인지 확인합니다.
     *
     * @param c 구분자인지 확인할 문자
     * @return 구분자인지(true) 아닌지(false) 여부
     */
    public boolean isDelimiter(char c) {
        int indexOfDelimiter = delimiters.indexOf(c);

        if (indexOfDelimiter == -1) {
            return false;
        }
        return true;
    }
}