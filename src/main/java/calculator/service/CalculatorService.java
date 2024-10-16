package calculator.service;

import calculator.domain.Calculator;

public class CalculatorService {
    // 여기 총 4개의 시나리오가 들어가면 좋을듯
    // 1. 입력 시나리오
    // 2. 커스틈 구분자 유/무 -> 있다면 커스터 제외하고 새로운 문자열 생성 후 리턴
    // 3. 문자열에서 숫자를 추출해서 모든 숫자의 합 리턴
    // 4. 출력 시나리오
    Calculator calculator = new Calculator();

    public void calculateContainCustomSeparator(String inputText) {
        String customSeparator = calculator.findCustomSeparator(inputText);
        String text = calculator.removeCustomReserveWord(inputText);
        String arr [] = calculator.extractNumber(customSeparator, text);
        calculator.sum(arr);
    }

    public void calculateContainOriginalSeparator(String inputText) {
        String arr[] = calculator.extractNumber(inputText);
        calculator.sum(arr);
    }

}
