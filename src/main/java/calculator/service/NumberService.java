package calculator.service;

import calculator.domain.Number;

import java.util.ArrayList;
import java.util.List;

public class NumberService {

    public static void extractNum(){
        String[] separatedVals = ValueService.getSeparatedValue();
        checkValidNum(separatedVals);
    }

    public static void checkValidNum(String[] separatedVals){
        List<Integer> numbers = new ArrayList<>();
        for(String separatedVal : separatedVals){
            int num = convertToInteger(separatedVal);
            if(num<0){
                throw new IllegalArgumentException("Invalid number format");
            }else{
                numbers.add(num);
            }
        }
        setNumbers(numbers);
    }

    public static Integer convertToInteger(String separatedVal){
        try {
            return Integer.parseInt(separatedVal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }
    }

    public static void setNumbers(List<Integer> numbers){
        Number.setNumbers(numbers);
    }

    public static List<Integer> getNumbers(){
        return Number.getNumbers();
    }
}
