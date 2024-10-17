package calculator.domain;

public class SumCalculator {
    public int sum(int[] numbers){
        int result = 0;
        for(int num : numbers){
            result += num;
        }

        return result;
    }
}
