package calculator.context;

public class Calculation {

    public int calculate(int[] arr) {
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return sum;
    }
}
