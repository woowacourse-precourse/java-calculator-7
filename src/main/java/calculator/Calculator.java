package calculator;

public class Calculator {
    public int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(); //음수는 허용 안됨
            }
            sum += number;
        }
        return sum;
    }
}

