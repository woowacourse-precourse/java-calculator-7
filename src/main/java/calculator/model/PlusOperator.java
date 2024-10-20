package calculator.model;


import calculator.error.CustomException;
import calculator.message.ErrorMessage;
import java.util.List;
import java.util.Optional;

public class PlusOperator implements Operator {

    @Override
    public int operate(List<Integer> numbers) {
        return Optional.of(numbers.stream()
                        .mapToInt(Integer::intValue)
                        .sum())
                .filter(sum -> sum >= 0) // 덧셈 결과 반환
                .orElseThrow(() -> CustomException.from(ErrorMessage.INTEGER_OUT_OF_RANGE));
    }
}
