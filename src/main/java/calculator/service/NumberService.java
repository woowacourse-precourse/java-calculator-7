package calculator.service;

import calculator.domain.Delimiter;
import calculator.domain.Number;

import java.util.List;

public class NumberService {

    private static final NumberService instance = new NumberService();

    public static NumberService getInstance() {
        return instance;
    }

    public void addNumbers(String str, Delimiter delimiter, Number number) {
        number.addAll(List.of(str.split(delimiter.toString())));
    }
}
