package calculator.model;

/**
 * 해당 클래스는 계산을 위한 클래스입니다.
 *
 * @author Kalsteve98
 * @since 1.0
 */
public class Calculator {
    /**
     * 계산 결과를 저장하는 변수
     */
    private Long result;

    /**
     * Calculator의 생성자입니다.
     */
    public Calculator() {
        result = 0L;
    }

    /**
     * 결과를 반환하는 메서드
     *
     * @return 계산 결과
     */
    public Long getResult() {
        return result;
    }

    /**
     * 덧셈을 수행하는 메서드
     *
     * @param number 더할 숫자
     * @return 계산 결과
     */
    public Long add(Long number) {
        result += number;
        return result;
    }
}
