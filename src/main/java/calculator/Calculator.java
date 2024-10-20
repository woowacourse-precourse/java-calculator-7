/**
 * 입력한 문자열에서 숫자를 추출하여 더하는 계산기 클래스
 *
 * @Package Name  : calculator
 * @Class Name    : Calculator
 * @Create Date   : 2024-10-20
 * @Create User   : 오시건
 */
package calculator;

public class Calculator {
    /**
     * 커스텀 구분자를 저장하는 변수
     */
    String delimiter = "";

    /**
     * 주어진 문자열이 기본 구분자만 사용했는지 커스텀 구분자도 사용했는지 확인
     *
     * @param input 확인할 문자열
     * @return 구분자별 계산 결과
     */
    public int checkInput(String input) {
        if (Character.isDigit(input.charAt(0))) {
            return calculateDefaultDelimiter(input);
        }
        return calculateCustomDelimiter(input);
    }

    /**
     * 기본 구분자만 사용한 문자열의 합을 계산
     *
     * @param input 계산할 문자열
     * @return 구분한 숫자들의 합
     */
    public int calculateDefaultDelimiter(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] tokens = input.split("[,:" + delimiter + "]+");
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    /**
     * 커스텀 구분자를 사용한 문자열의 합을 계산
     *
     * @param input 계산할 문자열
     * @return 구분한 숫자들의 합
     */
    public int calculateCustomDelimiter(String input) {
        if (input.length() == 5) {
            return 0;
        }
        delimiter = input.charAt(2) + "";
        return calculateDefaultDelimiter(input.substring(5));
    }
}
