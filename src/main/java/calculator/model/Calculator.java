package calculator.model;

//계산 기능 만을 담당하는 클래스
public class Calculator {

    public long addCalculate(final PositiveNumbers positiveNumbers) {

        long sum = 0;

        for (final Integer number : positiveNumbers.getNumbers()) {
            sum += number;
        }

        return sum;

    }
}
