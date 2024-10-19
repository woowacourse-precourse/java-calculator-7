package calculator.service;

import calculator.dto.request.ConverterRequest;
import calculator.dto.request.DelimiterExtractRequest;
import calculator.dto.request.SumRequest;
import calculator.dto.response.ConverterResponse;
import calculator.dto.response.DelimiterExtractResponse;
import calculator.dto.response.SumResponse;

public interface CalculatorService {
    DelimiterExtractResponse extractDelimiter(DelimiterExtractRequest input);
    ConverterResponse convertToList(ConverterRequest converterRequest);
    SumResponse getSumList(SumRequest sumRequest);
}
