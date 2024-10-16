package calculator;

import java.lang.reflect.Type;

public class Calculator {





    public int add(String input) {
        int sum = 0;

        if(input.isEmpty()){
            return sum;
        }
        boolean isNewDelimiter = checkNewDelimiter(input);

        String[] stringNumbers;
        if(isNewDelimiter){
            String newDelimiter = Character.toString(input.charAt(2));
            input = input.substring(5);
            stringNumbers = input.split(newDelimiter);
        }else{
            stringNumbers = InputUtils.splitInputs(input);
        }
        int[] numbers = InputUtils.StringToNumber(stringNumbers);

        for(int num : numbers){
           if(num < 0){
                throw new IllegalArgumentException("잘못된 입력을 하셨습니다.");
            }

            sum += num;
        }
        return sum;
    }


    private boolean checkNewDelimiter(String input){
        return input.startsWith("//");
    }
}
