package calculator.string;

/**
 * 문자열 계산기 클래스
 * 입력된 문자열을 파싱하고 숫자의 합을 계산
 */
public class StringCalculator {

    /**
     * 입력된 문자열의 숫자들을 더한 결과 반환
     *
     * @param input 계산할 숫자들이 포함된 문자열
     * @return 문자열에 포함된 숫자들의 합
     */
    public int add(String input) {
        // 빈 문자열이면 0 반환
        if(input.isEmpty()){
            return 0;
        }
        // 단일 숫자 처리. 수정 필요
        return Integer.parseInt(input);
    }
}
