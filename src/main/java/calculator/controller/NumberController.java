package calculator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.domain.Number;
import calculator.messages.ErrorMessages;

public class NumberController {
    private Number number;

    // 정규 표현식 형태의 구분자를 이용하여 문자열에서 숫자만 추출
    public void extractNumber(String inputString, String regex) {
        inputString = inputString.replaceAll("[//|\\\\n]", "").trim();

        // 구분자를 이용하여 숫자를 추출하는 과정에서 정규식에 포함되지 않은 구분자가 존재하는 경우 예외처리
        try {
            List<Integer> extractedNumbers = Arrays.stream(inputString.split(
                    regex))
                    .filter(element -> !element.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
                    
            number = new Number(extractedNumbers);
        } catch (IllegalArgumentException e) {
            throw e = new IllegalArgumentException(ErrorMessages.INVALID_SEPARTOR.getMessage());
        }
    }

    // 숫자를 리스트 형태로 반환
    public List<Integer> getNumbersToList() {
        return this.number.getNumbers();
    }
}
