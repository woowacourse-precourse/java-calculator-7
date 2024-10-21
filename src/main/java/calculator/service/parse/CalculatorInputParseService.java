package calculator.service.parse;

import java.util.List;

public interface CalculatorInputParseService {

    List<? extends Number> parseSumInput(String input);
}
