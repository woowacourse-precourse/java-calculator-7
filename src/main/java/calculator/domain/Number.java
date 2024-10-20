package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static final String CANNOT_INPUT_NEGATIVE_NUM = "음수는 입력할 수 없습니다.";
    private static final String CANNOT_INPUT_CHARACTER = "구분자 외의 문자는 입력 불가능합니다.";

    private List<Integer> numbers = new ArrayList<>();

    public Number(String[] separatedVals){
        for(String separatedVal : separatedVals){
            int num = convertToInteger(separatedVal);
            if(isPositiveNumber(num)){
                this.numbers.add(num);
            }
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private boolean isPositiveNumber(int num){
        if(num<0){
            throw new IllegalArgumentException(CANNOT_INPUT_NEGATIVE_NUM);
        }else{
            return true;
        }
    }

    private Integer convertToInteger(String separatedVal){
        try {
            if(separatedVal.isEmpty()){
                return 0;
            }
            return Integer.parseInt(separatedVal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CANNOT_INPUT_CHARACTER);
        }
    }
}
