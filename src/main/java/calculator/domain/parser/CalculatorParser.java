package calculator.domain.parser;

import calculator.domain.dto.InputRequest;
import calculator.domain.error.InputException;
import calculator.domain.message.ErrorMessage;
import calculator.domain.validation.CalculatorParserValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CalculatorParser {

    private CalculatorParser() {
    }

    /**
     * 주어진 입력 요청에서 구분자를 기반으로 숫자를 파싱하여 정수 리스트를 생성하는 메서드
     *
     * @param request 구분자와 입력 문자열을 포함하는 {@link InputRequest} 객체
     * @return 입력 문자열에서 파싱된 양수 정수의 리스트
     * @throws InputException 빈 문자열이 발견되거나, 양수가 아닌 입력이 포함된 경우
     */
    public static List<Integer> parseForDelimiters(InputRequest request) {
        String delimiters = request.delimiters();
        String targetInput = request.targetInput();

        String[] splitData = targetInput.split(delimiters, -1);
        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(splitData)
                .filter(data -> {
                    if (data.isEmpty()) {
                        throw InputException.from(ErrorMessage.DEFAULT_INPUT_MUST_START_WITH_NUMBER);
                    }
                    return true;
                })
                .forEach(data -> numbers.add(CalculatorParserValidator.parseToInt(data)));
        
        return numbers;
    }
}
