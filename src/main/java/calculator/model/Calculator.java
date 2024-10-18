package calculator.model;

public class Calculator {
    private int[] numbers; //추출된 숫자들
    private int sum; //숫자들의 합(정답)

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void doSum() {
        for(int i: numbers) {
            sum += i;
        }
    }
}
