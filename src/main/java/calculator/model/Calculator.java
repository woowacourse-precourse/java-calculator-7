package calculator.model;

public class Calculator {

    public static int arrSum(int[] intArr) {
        // 배열이
        int sum = 0;
        for (int i : intArr){
            sum += i;
        }
        return sum;
    }
}
