package calculator;

import java.lang.reflect.Type;

public class Calculator {

    private String delimiter = ",|:";

    public int add(String input) throws IllegalStateException{
        int sum = 0;

        if(input.isEmpty()){
            return sum;
        }
        boolean isNewDelimiter = checkNewDelimiter(input);

        String[] numbers;
        if(isNewDelimiter){
            delimiter = Character.toString(input.charAt(2));
            input = input.substring(5);
            numbers = input.split(delimiter);
        }else{
            numbers = input.split(delimiter);
        }


        for(String number : numbers){
            int num = Integer.parseInt((number));

            if(num < 0){
                throw new IllegalArgumentException();
            }

            sum += num;
        }
        return sum;
    }

    private boolean checkNewDelimiter(String input){
        return input.startsWith("//");
    }
}
