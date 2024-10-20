/**
 * 주어진 문자열의 유효성을 검사하는 클래스
 *
 * @Package name : calculator
 * @Class name   : InputValidator
 * @Create Date  : 2024-10-20
 * @Create User  : 오시건
 */

package calculator;

public class InputValidator {

    /**
     * 커스텀 구분자를 저장하는 변수
     */
    private String delimiter = "";

    /**
     * 입력된 문자열의 유효성 검사
     *
     * @param input 검사할 문자열
     * @return 입력된 문자열의 유효성 검사 결과 (true: 유효, false: 유효하지 않음)
     */
    public boolean checkDelimiter(String input) {
        if (input.isEmpty()) {
            return true;
        }
        if (Character.isDigit(input.charAt(0))) {
            return checkDefaultDelimiter(input);
        }
        if (input.startsWith("//")) {
            return checkCustomDelimiter(input);
        }
        return false;
    }

    /**
     * 기본 구분자를 사용하여 입력된 문자열이 유효한지 확인
     *
     * @param input 검사할 문자열
     * @return 입력된 문자열의 유효성 검사 결과 (true: 유효, false: 유효하지 않음)
     */
    private boolean checkDefaultDelimiter(String input) {
        if (input.isEmpty()) {
            return true;
        }
        return input.matches("^\\d+([,:" + delimiter + "]\\d+)*$");
    }

    /**
     * 커스텀 구분자를 사용하여 입력된 문자열이 유효한지 확인
     *
     * @param input 검사할 문자열
     * @return 입력된 문자열의 유효성 검사 결과 (true: 유효, false: 유효하지 않음)
     */
    private boolean checkCustomDelimiter(String input) {
        delimiter = String.valueOf(input.charAt(2));
        return input.startsWith("\\n", 3) && checkDefaultDelimiter(input.substring(5));
    }
}
