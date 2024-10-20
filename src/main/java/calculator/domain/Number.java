package calculator.domain;

/**
 * Number : 계산기에서 사용되는 양의 정수 값 나타내는 불변 객체
 **/
public record Number(int value) {

    /**
     * 다른 값 객체를 입력받아(Other) 기존 값에 더하여 반환
     *
     * @param other 더할 다른 Number 객체
     * @return 두 값의 합을 나타내는 새로운 Number 객체
     */
    public Number add(Number other) {
        return new Number(this.value + other.value);
    }

    /**
     * Number 객체의 값을 문자열로 변환
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
