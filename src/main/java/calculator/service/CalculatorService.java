package calculator.service;

import calculator.dto.request.CalculatorRequest;
import calculator.dto.request.ConverterRequest;
import calculator.dto.request.DelimiterExtractRequest;
import calculator.dto.response.CalculatorResponse;
import calculator.dto.response.ConverterResponse;
import calculator.dto.response.DelimiterExtractResponse;

public interface CalculatorService {
    CalculatorResponse calculateInput(CalculatorRequest calculatorRequest);
    DelimiterExtractResponse extractDelimiter(DelimiterExtractRequest delimiterExtractRequest);
    ConverterResponse convertToList(ConverterRequest converterRequest);
}
