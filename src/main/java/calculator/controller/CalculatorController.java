package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.NumberValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static calculator.domain.InputValidator.*;
import static calculator.domain.InputValidator.removeSeparatorInfo;
import static calculator.domain.InputValidator.separate;

public class CalculatorController {

    private static List<String> basicSeparators = new ArrayList<>();
    private static List<String> customSeparators = new ArrayList<>();

    /**
     * 계산기 실행
     */
    public void start() {
        String input = InputView.readLine();

        // 기본 구분자 초기화
        initBasicSeparators();

        // 커스텀 구분자가 존재하는 경우, 커스텀 구분자 추출
        if (isExistCustomSeparator(input)) {
            customSeparators = getCustomSeparator(input);
            input = removeSeparatorInfo(input);  // 커스텀 구분자 정보 제거
        }

        // 구분자 합치기
        List<String> separators = getTotalSeparator(basicSeparators, customSeparators);

        // 구분자로 숫자 추출
        List<Integer> numbers = separate(input, separators);

        // 숫자에 대한 유효성 검사(양수 체크)
        NumberValidator.isPositiveNumber(numbers);

        // 계산기를 통해 모두 더하기
        int result = Calculator.add(numbers);

        // 결과 출력
        OutputView.printResult(result);
    }

    /**
     * 기본 구분자(쉼표, 콜론) 생성
     */
    public void initBasicSeparators() {
        basicSeparators.add(",");
        basicSeparators.add(":");
    }

    /**
     * 기본 구분자와 커스텀 구분자를 하나로 합치기
     */
    public List<String> getTotalSeparator(List<String> basic, List<String> custom) {
        List<String> separators = new ArrayList<>();

        for (String separator : basic) {
            separators.add(separator);
        }
        for (String separator : custom) {
            separators.add(separator);
        }
        return separators;
    }
}
