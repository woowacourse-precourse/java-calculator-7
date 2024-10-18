package calculator;

public class Calculator {
    public int add(int[] intArray){
        int sum = 0;
        for (int value : intArray) {
            sum += value;
        }
        return sum;
    }
}
