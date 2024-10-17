package calculator.service.generator;

import calculator.number.service.NumberCrateService;
import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;
import calculator.separator.service.SeparatorCreateService;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CreateProcess implements SeparatorCreateService, NumberCrateService {

    @Override
    public <R> R createSeprator(Sentence sentence, Function<String, String> transFunction,
                                Function<String, R> constructor) {
        String extractedValue = transFunction.apply(sentence.getSentence());
        return constructor.apply(extractedValue);
    }

    @Override
    public <R> R createNumber(Sentence sentence,
                              Function<String, String> transFunction,
                              BiFunction<String,Separator, R> constructor,
                              Separator separator) {
        String extractedValue = transFunction.apply(sentence.getSentence());
        return constructor.apply(extractedValue, separator);
    }
}
