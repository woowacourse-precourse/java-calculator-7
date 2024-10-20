package calculator;

import java.math.BigDecimal;
import java.util.List;

public class DependencyInjection {
    private final ConsoleService consoleService;
    private final DelService delService;
    private final CalculatorService calculatorService;

    public DependencyInjection(ConsoleService consoleService, DelService delService,
                               CalculatorService calculatorService) {
        this.consoleService = consoleService;
        this.delService = delService;
        this.calculatorService = calculatorService;
    }

    public void execute() {  // static 제거
        try {
            // 1. 입력 받기
            String input = consoleService.getInput();

            // 2. 구분자 처리 및 숫자 추출
            List<String> numberStrings = delService.processInputAndExtractNumbers(input);

            // 3. 숫자 처리 및 계산
            List<BigDecimal> numbers = calculatorService.processNumbers(numberStrings);
            BigDecimal result = calculatorService.calculateSum(numbers);

            // 4. 결과 출력
            consoleService.printResult(result);
        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 입력: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("오류 발생: " + e.getMessage());
            throw e;
        }
    }
}
