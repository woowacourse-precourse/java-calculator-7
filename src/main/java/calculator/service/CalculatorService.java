package calculator.service;

import java.util.List;

public interface CalculatorService {

    int operation(List<String> numList);

    List<String> splitDigits(String s);
}
