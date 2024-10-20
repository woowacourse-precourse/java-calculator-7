package calculator.domain;

import java.util.List;
import static calculator.message.ErrorMessage.INVALID_NEGATIVE_NUM;

public class Numbers {
    private final AddNumber addNumber;
    public Numbers(List<Integer> numbers){
        this.addNumber = new AddNumber();
        validateNumbers(numbers);
    }
    public int addNumbers(List<Integer> numbers){
        return addNumber.getSum(numbers);
    }
    private void validateNumbers(final List<Integer> numbers) {
        for(Integer number:numbers){
            if(number < 0){
                throw new IllegalArgumentException(INVALID_NEGATIVE_NUM.getMessage());
            }
        }
    }
}
