package calculator.domain;

public class SumCalculator {
    private int result = 0;

    public int getResult(String[] inputNumber){
        calculateResult(inputNumber);
        return this.result;
    }
    private void calculateResult(String[] inputNumber){
        for(String num : inputNumber){
            if(Integer.parseInt(num) < 0){
                throw new IllegalArgumentException("숫자는 양수를 입력해야 합니다.");
            }
            this.result += Integer.parseInt(num);
        }
    }
}
