package calculator.addCalculator;

public class AddCalculator {
    public int calculateSum(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            sum += Integer.parseInt(number);

        }
        return sum;
    }
}
