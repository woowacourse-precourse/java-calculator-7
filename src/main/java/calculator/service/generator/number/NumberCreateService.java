package calculator.service.generator.number;

import calculator.number.domain.NumberService;
import calculator.number.util.NumberConvertorService;
import calculator.sentence.dto.Sentence;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public interface NumberCreateService {
    NumberService createNumber(
            Sentence sentence,
            Function<String, List<String>> transFunction,
            Supplier<NumberConvertorService> convertorServiceSupplier,
            Function<List<Number>, NumberService> constructor);
}
