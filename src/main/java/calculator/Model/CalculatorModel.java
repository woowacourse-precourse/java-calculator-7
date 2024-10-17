package calculator.Model;

public class CalculatorModel {

    public int calculateSum(String[] tokens){
        int sum = 0;
        for(String token : tokens){
            int number = Integer.parseInt(token);
            sum += number;
        }
        return sum;
    }
}
