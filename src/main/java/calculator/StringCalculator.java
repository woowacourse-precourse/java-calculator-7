package calculator;

import com.sun.security.jgss.GSSUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        // input null or 0
        if (isBlank(input)) {
            return 0;
        }
        // 구분자 "," 입력
       return sum(toInts(split(input)));
    }
    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
    private String[] split(String input) {
        String separator = ",|:";
        if (input.startsWith("//")) {
            String customPart = input.substring(2, 3);
            separator += "|" + customPart;
            input = input.substring(5);
        }
        return input.split(separator);
    }


    private int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i =0; i < values.length; i++){
            int number = Integer.parseInt(values[i]);
            if(number < 0){
                throw new IllegalArgumentException();
            }
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }
}
