package calculator.generator.number.impl;

import calculator.generator.number.NumberCreateService;
import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;

import java.util.function.BiFunction;
import java.util.function.Function;

public class NumberCreateProcess implements NumberCreateService {
    @Override
    public <R> R createNumber(Sentence sentence,
                              Function<String, String> transFunction,
                              BiFunction<String,Separator, R> constructor,
                              Separator separator) {
        String extractedValue = transFunction.apply(sentence.getSentence());
        return constructor.apply(extractedValue, separator);
    }
}
