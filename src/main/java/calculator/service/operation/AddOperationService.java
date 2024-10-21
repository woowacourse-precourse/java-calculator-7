package calculator.service.operation;

import calculator.service.dto.NumbersDto;
import calculator.service.dto.SumDto;

public class AddOperationService implements OperationService {

    @Override
    public SumDto operate(NumbersDto numbersDto) {
        int value = numbersDto.values()
                .stream()
                .mapToInt(numberDto -> numberDto.value())
                .sum();

        return SumDto.from(value);
    }
}
