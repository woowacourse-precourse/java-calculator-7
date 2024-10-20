package calculator.parser;

import calculator.dto.InputRequest;
import calculator.error.CustomException;
import calculator.message.ErrorMessage;
import calculator.validation.CalculateValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CalculatorParser {

    public CalculatorParser() {
    }

    public static List<Integer> parseForDelimiters(InputRequest request) {
        String delimiters = request.delimiters();
        String targetInput = request.targetInput();

        return Optional.of(targetInput)
                .filter(input -> !input.isEmpty())
                .map(input -> input.split(delimiters, -1))
                .stream()
                .flatMap(Arrays::stream)
                .map(CalculatorParser::validateInput) // 입력값 검증
                .map(CalculateValidator::parseToInt)  // 문자열 정수 변환
                .collect(Collectors.toCollection(ArrayList::new));
    }


    private static String validateInput(String data) {
        return Optional.of(data)
                .filter(dataValue -> !dataValue.isEmpty())
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_INPUT));
    }
}

