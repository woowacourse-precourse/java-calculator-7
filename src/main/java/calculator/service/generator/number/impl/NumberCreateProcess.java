package calculator.service.generator.number.impl;

import calculator.service.generator.number.NumberCreateService;
import calculator.number.domain.NumberService;
import calculator.number.util.NumberConvertorService;
import calculator.sentence.dto.Sentence;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class NumberCreateProcess implements NumberCreateService {

    @Override
    public NumberService createNumber(
            Sentence sentence,
            Function<String, List<String>> transFunction,
            Supplier<NumberConvertorService> convertorService,
            Function<List<Number>, NumberService> constructor) {
        List<String> stringToSplitBySeparator = transFunction.apply(sentence.getSentence());
        NumberConvertorService numberConvertorService = convertorService.get();
        List<Number> converterValue = numberConvertorService.stringListToNumberList(stringToSplitBySeparator);
        return constructor.apply(converterValue);
    }
}
