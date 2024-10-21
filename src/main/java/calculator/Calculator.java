package calculator;

public class Calculator {
    public int[] toIntArray(String[] parsedList) {
        int[] numbers = new int[parsedList.length];
        for (int i = 0; i < parsedList.length; i++) {
            numbers[i] = Integer.parseInt(parsedList[i]);
        }
        return numbers;
    }

    public int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
