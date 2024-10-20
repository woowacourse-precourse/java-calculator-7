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
        // 커스텀 문자열을 표시하는 "//"와 "\n"을 제거
        inputString = inputString.replaceAll("[//\\\\n]", "");

        // 구분자를 이용하여 숫자를 추출하는 과정에서 정규식에 포함되지 은 구분자가 존재하는 경우 예외처리
        try {
            System.out.println("input : " + inputString);
            // 정규 표현식으로 나타낸 구분자들을 이용하여 숫자만 추출
            List<Integer> extractedNumbers = Arrays.stream(inputString.split(regex))
                    .filter(element -> !element.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 커스텀 구분자와 기본 구분자에 해당하지 않는 문자가 입력되면 생성자 호출시 파라미터 검증 과정에서 에러 발생
            number = new Number(extractedNumbers);
        } catch (IllegalArgumentException e) {
            throw e = new IllegalArgumentException(ErrorMessages.INVALID_DELIMITER.getMessage());
        }
    }

    // 숫자를 리스트 형태로 반환
    public List<Integer> getNumbersToList() {
        return this.number.getNumbers();
    }
}
