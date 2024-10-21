package calculator.service;

import java.math.BigDecimal;

public interface Calculator {
    void initValues(String input);
    BigDecimal execute();
}