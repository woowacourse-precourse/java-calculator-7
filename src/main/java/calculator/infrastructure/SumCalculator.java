package calculator.infrastructure;

import calculator.common.exception.OutOfLongRangeException;
import calculator.domain.Number;
import java.util.List;

public class SumCalculator {
    /*
     * Number 리스트의 각 요소를 long 타입 변수 sum 에 더한다.
     * 이때 long 타입 범위를 벗어나지 않도록 try catch 로 감싼다.
     * addExact 메서드를 사용하여 오버플로우 발생 시 예외를 던지도록 한다.
     */
    public long addAllNumbers(List<Number> numberList) {
        long sum = 0L;
        for (Number number : numberList) {
            try {
                sum = Math.addExact(sum, number.getNumberValue());
            } catch (ArithmeticException e) {
                throw new OutOfLongRangeException(sum, number.getNumberValue(), e);
            }
        }
        return sum;
    }
}
