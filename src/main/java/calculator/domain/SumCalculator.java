package calculator.domain;

public class SumCalculator {
    private int result = 0;

    public int getResult(String[] inputNumber){
        calculateResult(inputNumber);
        return this.result;
    }
    private void calculateResult(String[] inputNumber){
        for(String num : inputNumber){
            this.result += Integer.parseInt(num);
        }
    }
}
