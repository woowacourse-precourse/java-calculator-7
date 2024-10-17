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
