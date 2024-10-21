package calculator.model;

import calculator.errorMessage.CustomException;
import calculator.errorMessage.ErrorMessage;

import java.util.List;

public class AddOperator implements Operator{

    /**
     * 숫자 리스트에 있는 정수들을 더해서 반환 해주는 메서드
     * @param numberList 숫자 리스트
     * @return 결과 값
     */
    @Override
    public int operate(List<Integer> numberList){
        int sum = numberList.stream().mapToInt(Integer::intValue).sum();

        if(sum < 0){
            throw new CustomException(ErrorMessage.NUMBER_RANGE_ERROR);
        }

        return sum;
    }
}
