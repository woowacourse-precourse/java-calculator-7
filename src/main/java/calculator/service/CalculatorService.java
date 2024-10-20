package calculator.service;

import calculator.domain.DelimiterAndNumber;
import calculator.exception.CalculatorException;
import calculator.validation.DelimiterValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");


    // 기본 구분자, 커스텀 구분자 타입 체크
    private DelimiterAndNumber isDelimiterCustomOrDefault(String input, DelimiterValidation validation) {
        DelimiterAndNumber delimiterAndNumberInput;

        if (validation.isCustomDelimiter(input)) {
            delimiterAndNumberInput = getCustomInputParse(input);
        } else {
            delimiterAndNumberInput = new DelimiterAndNumber(DEFAULT_DELIMITERS, input);
        }

        return delimiterAndNumberInput;
    }

}
