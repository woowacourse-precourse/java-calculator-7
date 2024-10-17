package calculator.Model;

public class CalculatorModel {

    public long calculateSum(String[] tokens){
        long sum = 0;
        for(String token : tokens){
            long number = (long) Integer.parseInt(token);
            sum += number;
        }
        return sum;
    }
}
