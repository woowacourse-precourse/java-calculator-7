package calculator.service;

import calculator.domain.Number;
import calculator.util.InputParser;
import calculator.util.NumberValidator;
import java.util.List;

public class CalculatorService {
    private final InputParser parser;
    private final NumberValidator validator;

    public CalculatorService() {
        this.parser = new InputParser();
        this.validator = new NumberValidator();
    }

    public Number calculate(String input) {
        List<String> numbers = parser.parse(input);

        return sum(numbers);
    }

    /**
     * 주어진 문자열 리스트에서 숫자를 추출하고 합산하여 반환 문자열에서 공백을 제거하고 유효성을 검사한 후, 각 문자열을 숫자로 변환 빈 문자열("")은 무시
     *
     * @param numbers
     * @return
     */
    //StringCalculatro 의 숫자 합산 로직은 서비스 로직에 더 가깝다
    private Number sum(List<String> numbers) {
        return numbers.stream()
                .filter(s -> !s.trim().isEmpty()) // 빈 문자열을 제외 (공백을 제거한 후 비어있는 문자열은 제외)
                .peek(validator::validate) //숫자 유효성 검사(NumberValidator)
                .map(num -> new Number(Integer.parseInt(num.trim()))) // 문자열 > Integer > Number 객체로
                .reduce(new Number(0), Number::add); // Number 객체 모두 더하기
    }
}