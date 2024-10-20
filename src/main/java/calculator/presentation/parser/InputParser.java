package calculator.presentation.parser;

import calculator.presentation.request.CalculatorRequest;

public interface InputParser {

    CalculatorRequest parseToRequest(String input);
}
