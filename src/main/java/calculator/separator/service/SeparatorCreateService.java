package calculator.separator.service;

import calculator.number.domain.Number;
import calculator.separator.domain.Separator;

import java.util.function.Function;
import java.util.function.Supplier;

public interface CreateService {
    <R> R create(String sentence, Function<String, String> transFunction, Function<String, R> constructor);
}
