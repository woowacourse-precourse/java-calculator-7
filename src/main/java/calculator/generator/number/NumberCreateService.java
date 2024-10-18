package calculator.generator.number;

import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface NumberCreateService {
    <R> R createNumber(Sentence sentence, Function<String, String> transFunction,
                              BiFunction<String,Separator, R> constructor, Separator separator);
}
