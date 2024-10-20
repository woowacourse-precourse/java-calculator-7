package calculator.service;

import calculator.domain.Validator;
import java.util.ArrayList;
import java.util.List;

public class ConverterService {
    private final Validator validator;

    public ConverterService() {
        this.validator = new Validator();
    }

    public List<Integer> toNumbers(List<String> stringInputs) {
        List<String> sanitizedInputs = sanitizeInputs(stringInputs);   // 문자열이 공백인 경우 0으로 처리
        validateInputs(sanitizedInputs);                               // 문자열 숫자 검증
        return convertToNumbers(sanitizedInputs);
    }

    public List<String> sanitizeInputs(List<String> stringInputs) { // 공백 0으로 처리
        List<String> sanitizedInputs = new ArrayList<>();
        for (String s : stringInputs) {
            sanitizedInputs.add(sanitizeInput(s));
        }
        return sanitizedInputs;
    }

    public String sanitizeInput(String input) {
        return input.trim().isEmpty() ? "0" : input.trim();  // 한 개 이상 공백 0으로 처리
    }

    public void validateInputs(List<String> sanitizedInputs) {
        validator.validateInputs(sanitizedInputs);
    }

    public List<Integer> convertToNumbers(List<String> sanitizedInputs) {
        List<Integer> numberInputs = new ArrayList<>();
        for (String s : sanitizedInputs) {
            numberInputs.add(Integer.parseInt(s));
        }
        return numberInputs;
    }

}
