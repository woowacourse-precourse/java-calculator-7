package calculator.service.operation;

import calculator.service.dto.NumbersDto;
import calculator.service.dto.SumDto;

public interface OperationService {

    SumDto operate(NumbersDto numbersDto);
}
