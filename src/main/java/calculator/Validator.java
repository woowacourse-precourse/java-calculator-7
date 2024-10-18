package calculator;

public class Validator {
    /**
     * 빈 문자열 입력시 예외 처리
     * @param inputString
     * @return 빈 문자열일 경우 true
     */
    public static boolean isEmptyString(String inputString) {

        return inputString == null || inputString.isEmpty();
    }

    /**
     * 잘못된 형식의 커스텀 구분자 생성시 예외 처리
     * @param delimiterIndex
     */
    public static void isInvalidCustomDelimiter(int delimiterIndex) {

        if(delimiterIndex == -1){
            throw new IllegalArgumentException("구분자 지정이 잘못되었습니다.");
        }
    }

    /**
     * 구분자 연속 사용, 음수, 숫자 아닌값 예외 처리
     * @param number
     * @return
     */
    public static int parsePositiveInt(String number) {

        try {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("잘못된 형식입니다. 구분자가 연속으로 사용되었습니다.");
            }

            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
