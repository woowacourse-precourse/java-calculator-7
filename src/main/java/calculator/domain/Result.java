package calculator.domain;

/**
 * 프로그램의 출력값인 수열(NumericSequence)의 합을 담은 클래스
 */
public class Result {
    private final int value;

    public Result(NumericSequence sequence) {
        this.value = sequence.getTotalSum();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
