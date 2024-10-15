package calculator.model;

public class StringCalculator {

    // TODO 숫자 더하는 함수 구현
    public int add(String input) {
        if (input != null || input.isEmpty()) {
            return 0;
        }
       String[] numbers = input.split(",|:");
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers){
            total += Integer.parseInt(number);
        }
        return total;
    }
}
