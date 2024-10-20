package calculator.model.calculator;

public class SumCalculator implements Calculator {

    @Override
    public int calculate(int [] numbers) {
        int answer = 0;
        for(int i=0; i<numbers.length; i++) {
            answer+=numbers[i];
        }
        return answer;
    }

}
