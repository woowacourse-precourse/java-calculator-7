package calculator;

public class Calculator {
    // Split numbers using the default delimiters and calculate
    public int add (String input){
        String delimiter = ",|:";

        String[] numbers = input.split(delimiter);

        return calculate(numbers);
    }


    private int calculate(String[] numbers){
        int sum =0;
        for(String number : numbers){
            int num = Integer.parseInt(number);
            sum +=num;
        }
        return sum;
    }
}
