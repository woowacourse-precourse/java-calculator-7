package calculator.service;

import calculator.domain.Number;

import java.util.ArrayList;
import java.util.List;

public class NumberService {
    private static final String CANNOT_INPUT_NEGATIVE_NUM = "음수는 입력할 수 없습니다.";
    private static final String CANNOT_INPUT_CHARACTER = "구분자 외의 문자는 입력 불가능합니다.";

    public static void extractNum(){
        String[] separatedVals = ValueService.getSeparatedValue();
        checkValidNum(separatedVals);
    }

    public static void checkValidNum(String[] separatedVals){
        List<Integer> numbers = new ArrayList<>();
        for(String separatedVal : separatedVals){
            int num = convertToInteger(separatedVal);
            if(num<0){
                throw new IllegalArgumentException(CANNOT_INPUT_NEGATIVE_NUM);
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
            throw new IllegalArgumentException(CANNOT_INPUT_CHARACTER);
        }
    }

    public static void setNumbers(List<Integer> numbers){
        Number.setNumbers(numbers);
    }

    public static List<Integer> getNumbers(){
        return Number.getNumbers();
    }
}
