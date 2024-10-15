package calculator;

public class Calculator {

    private String delimiter = ",|:";

    public int add(String input){
        int sum = 0;
        String[] numbers = input.split(delimiter);
        for(String number : numbers){
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
