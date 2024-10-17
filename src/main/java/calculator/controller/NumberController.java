package calculator.controller;

import calculator.domain.Number;
import calculator.messages.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberController {
    private Number number;

    // 정규 표현식 형태의 구분자를 이용하여 문자열에서 숫자만 추출
    public void extractNumber(String inputString, String regex) {
        inputString = inputString.replaceAll("[//|\\\\n]", "").trim();

        try {
            List<Integer> extractedNumbers = Arrays.stream(inputString.split(
                    regex))
                    .filter(element -> !element.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            number = new Number(extractedNumbers);
        } catch (IllegalArgumentException e) {
            throw e = new IllegalArgumentException(ErrorMessages.INVALID_INPUT.getMessage());
        }
    }

    // 숫자를 리스트 형태로 반환
    public List<Integer> getNumbersToList() {
        return this.number.getNumbers();
    }
}
