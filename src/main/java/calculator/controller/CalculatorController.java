package calculator.controller;

import calculator.domain.Separator;
import calculator.service.CalculatorService;
import calculator.service.ConverterService;
import calculator.service.SeparatorService;
import calculator.service.SplitterService;
import calculator.view.InputView;
import java.util.List;

public class CalculatorController {
    private Separator separator;
    private final CalculatorService calculatorService;
    private final SeparatorService separatorService;
    private final ConverterService converterService;
    private final SplitterService splitterService;

    public CalculatorController(Separator separator){
        this.separator = separator;
        this.calculatorService = new CalculatorService();
        this.separatorService = new SeparatorService(separator);
        this.converterService = new ConverterService();
        this.splitterService = new SplitterService();
    }

    public int run(String input) {
        String processedInput = separatorService.processCustomSeparator(input);        // 커스텀 구분자 추출
        List<String> separators = separator.getSeparators();                           // 구분자 가져오기

        List<String> stringInputs = splitterService.split(processedInput, separators);   // 구분자로 문자열 분리
        List<Integer> numberInputs = converterService.toNumbers(stringInputs);           // 분리된 문자열 숫자로 변환

        return calculatorService.calculate(numberInputs);                                    // 숫자 합 계산
    }
}
