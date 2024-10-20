package calculator.service;

import calculator.dto.request.CalculatorRequest;
import calculator.dto.request.ConverterRequest;
import calculator.dto.request.DelimiterExtractRequest;
import calculator.dto.response.CalculatorResponse;
import calculator.dto.response.ConverterResponse;
import calculator.dto.response.DelimiterExtractResponse;
import calculator.model.Calculator;
import calculator.model.exception.CalculatorErrorMessage;
import calculator.model.exception.CalculatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorServiceImpl implements CalculatorService{
    private final String DEFAULT_DELIMITER = ",|:";
    private final int CUSTOM_DELIMITER_LENGTH = 5;
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final Pattern CAPTURE_CUSTOM_DELIMITER = Pattern.compile("^//(.)\\\\n");
    private final String CONTINUOUS_REGEX = "{2,}";

    @Override
    public CalculatorResponse calculateInput(CalculatorRequest calculatorRequest) {
        DelimiterExtractResponse extracted = extractDelimiter(new DelimiterExtractRequest((calculatorRequest.getInput())));
        ConverterResponse converted = convertToList(new ConverterRequest(extracted.getDelimiter(), extracted.getRemainInput()));
        Calculator calculator = new Calculator(converted.getNumbers());
        return new CalculatorResponse(calculator.getSum());
    }

    @Override
    public DelimiterExtractResponse extractDelimiter(DelimiterExtractRequest extractRequest) {
        String input = extractRequest.getInput();

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
        String delimiter = converterRequest.getDelimiter();
        String remainInput = converterRequest.getRemainInput();

        if(remainInput.isEmpty()){
            return new ConverterResponse(new ArrayList<>());
        }

        if(isOnlyOneDelimiter(delimiter, remainInput)){
            return new ConverterResponse(new ArrayList<>());
        }

        isValidateDelimiter(delimiter, remainInput);

        List<Integer> convertNumber = new ArrayList<>();

        for(String s : remainInput.split(delimiter)){
            int number = convertToInt(s);

            isPositiveNumber(number);

            convertNumber.add(number);
        }

        return new ConverterResponse(convertNumber);
    }

    private boolean isOnlyOneDelimiter(String delimiter, String remainInput) {
        Pattern pattern = Pattern.compile(delimiter);
        Matcher matcher = pattern.matcher(remainInput);

        return matcher.matches();
    }

    private int convertToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new CalculatorException(CalculatorErrorMessage.INVALID_LETTER_ERROR);
        }
    }

    private void isPositiveNumber(int number){
        if(number <= 0){
            throw new CalculatorException(CalculatorErrorMessage.INVALID_NUMBER_ERROR);
        }
    }

    private void isValidateDelimiter(String delimiter, String remainInput) {
        StringBuilder delimiterBuilder = new StringBuilder();
        String[] splitDelimiter = delimiter.split("|");

        delimiterBuilder.append(splitDelimiter[0]).append(CONTINUOUS_REGEX)
                .append("|").append(splitDelimiter[1]).append(splitDelimiter[1]).append(CONTINUOUS_REGEX);

        // ".|:|\\|" 및 ".|:|\\{"인 경우
        if(splitDelimiter.length == 3){
            getDelimiterBuilder(delimiterBuilder.append("|"), splitDelimiter[2]);
        }

        if(findContinuousDelimiter(remainInput, delimiterBuilder.toString())){
            throw new CalculatorException(CalculatorErrorMessage.INVALID_CONTINUOUS_DELIMITER_ERROR);
        }
    }

    private void getDelimiterBuilder(StringBuilder builder, String customDelimiter){
        if(customDelimiter.equals("{") || customDelimiter.equals("|")){
            builder.append("\\").append(customDelimiter).append(CONTINUOUS_REGEX);
            return;
        }

        builder.append(customDelimiter).append(CONTINUOUS_REGEX);
    }

    private boolean findContinuousDelimiter(String continuousRegex, String remainInput){
        Pattern pattern = Pattern.compile(continuousRegex);
        Matcher matcher = pattern.matcher(remainInput);

        return matcher.find();
    }
}
