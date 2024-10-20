package calculator.model.calculator;

public class SumCalculator implements Calculator {

    @Override
    public long calculate(long [] numbers) {
        long answer = 0;
        for(int i=0; i<numbers.length; i++) {
            answer+=numbers[i];
        }
        return answer;
    }

}
