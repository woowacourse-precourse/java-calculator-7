package calculator.dto.response;

import java.util.List;

public class ConverterResponse {
    private final List<Integer> numbers;

    public ConverterResponse(List<Integer> numbers){
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
