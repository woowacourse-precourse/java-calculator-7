package calculator.service;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    public List<String> splitByDelimiters(String input) {
        String delimiter = ",|:"; // 기본 구분자
        return Arrays.stream(input.split(delimiter))
                .toList();
    }
}

