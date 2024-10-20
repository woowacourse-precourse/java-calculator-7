package calculator.service;

import calculator.dto.request.ConverterRequest;
import calculator.dto.request.DelimiterExtractRequest;
import calculator.dto.response.ConverterResponse;
import calculator.dto.response.DelimiterExtractResponse;

public interface CalculatorService {
    int addInput(String input);
    DelimiterExtractResponse extractDelimiter(DelimiterExtractRequest delimiterExtractRequest);
    ConverterResponse convertToList(ConverterRequest converterRequest);
}
