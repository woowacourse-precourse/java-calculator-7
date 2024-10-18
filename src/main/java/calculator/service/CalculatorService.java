package calculator.service;

import calculator.model.Delimiters;
import calculator.util.ExtractionUtil;

public class CalculatorService {

    public String calculate(String rawInput) {
        Delimiters delimiters = Delimiters.from(rawInput);
        String expression = ExtractionUtil.extractExpression(rawInput);
        // todo : 계산식의 유효 검증
        // todo : delimiterSet에 따라 expression을 ElementList로 변환하기
        // todo : Calculator를 이용하여 계산 진행
        return ""; // todo : 연산 결과 반환
    }
}
