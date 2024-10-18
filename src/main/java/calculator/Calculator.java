package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }

        String[] numbers;
        if(input.startsWith("//")){ // 미구현
            numbers = input.split(" ");
        }
        else{
            String delimiters = ",|:";
            numbers = input.split(delimiters);
        }
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for(String number : numbers){
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }
}
