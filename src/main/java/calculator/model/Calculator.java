package calculator.model;

import java.math.BigDecimal;

public interface Calculator {
    void insertValues(String input);
    void extract();
    BigDecimal sum();
}