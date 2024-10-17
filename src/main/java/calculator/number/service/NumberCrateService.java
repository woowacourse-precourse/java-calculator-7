package calculator.number.service;

import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface NumberCrateService {
    <R> R createNumber(Sentence sentence, Function<String, String> transFunction,
                              BiFunction<String,Separator, R> constructor, Separator separator);
}
