package calculator.model;

import calculator.errorMessage.CustomException;
import calculator.errorMessage.ErrorMessage;

import java.util.List;

public class AddOperator implements Operator{

    @Override
    public int operate(List<Integer> numberList){
        int sum = numberList.stream().mapToInt(Integer::intValue).sum();

        if(sum < 0){
            throw new CustomException(ErrorMessage.NUMBER_RANGE_ERROR);
        }

        return sum;
    }
}
