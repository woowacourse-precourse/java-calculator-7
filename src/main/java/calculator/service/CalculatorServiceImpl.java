package calculator.service;

import calculator.dto.request.ConverterRequest;
import calculator.dto.request.DelimiterExtractRequest;
import calculator.dto.request.SumRequest;
import calculator.dto.response.ConverterResponse;
import calculator.dto.response.DelimiterExtractResponse;
import calculator.dto.response.SumResponse;
import calculator.model.exception.CalculatorErrorMessage;
import calculator.model.exception.CalculatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorServiceImpl implements CalculatorService{
    private final String DEFAULT_DELIMITER = ",|:";
    private final int CUSTOM_DELIMITER_LENGTH = 5;
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final Pattern CAPTURE_CUSTOM_DELIMITER = Pattern.compile("^//(.)\\\\n");
    private final String CONTINUOUS_REGEX = "{2,}";

    @Override
    public DelimiterExtractResponse extractDelimiter(DelimiterExtractRequest extractRequest) {
        String input = extractRequest.toString();

        if(input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.length() >= CUSTOM_DELIMITER_LENGTH){
            return extractCustomDelimiter(input);
        }

        return new DelimiterExtractResponse(DEFAULT_DELIMITER, input);
    }

    private DelimiterExtractResponse extractCustomDelimiter(String input){
        Matcher matcher = CAPTURE_CUSTOM_DELIMITER.matcher(input);
        StringBuilder delimiter = new StringBuilder();
        StringBuilder remainInput = new StringBuilder();

        if(!matcher.find()){
            throw new CalculatorException(CalculatorErrorMessage.INVALID_CUSTOM_DELIMITER_SEPARATION_ERROR);
        }

        if(containsDefaultDelimiter(matcher.group())){
            throw new CalculatorException(CalculatorErrorMessage.CONTAIN_DEFAULT_DELIMITER_ERROR);
        }

        delimiter.append(DEFAULT_DELIMITER).append("|").append(matcher.group(1));
        remainInput.append(input.substring(matcher.end()));

        return new DelimiterExtractResponse(delimiter.toString(), remainInput.toString());
    }

    private boolean containsDefaultDelimiter(String customDelimiter){
        Pattern pattern = Pattern.compile(DEFAULT_DELIMITER);
        Matcher matcher = pattern.matcher(customDelimiter);

        return matcher.find();
    }

    @Override
    public ConverterResponse convertToList(ConverterRequest converterRequest) {

        return null;
    }

    @Override
    public SumResponse getSumList(SumRequest sumRequest) {

        return null;
    }
}
