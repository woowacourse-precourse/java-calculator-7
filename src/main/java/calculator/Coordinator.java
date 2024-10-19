package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Coordinator {
    private final IOService IOService;
    private final DelimiterService delimiterService;
    private final NumberService numberService;

    public Coordinator(IOService IOService, DelimiterService delimiterService, NumberService numberService) {
        this.IOService = IOService;
        this.delimiterService = delimiterService;
        this.numberService = numberService;
    }

    public void execute() {
        try {
            // 1. 입력 받기
            String input = IOService.getInput();

            // 2. 구분자 처리 및 숫자 추출
            List<String> numberStrings = delimiterService.processInputAndExtractNumbers(input);

            // 3. 숫자 처리 및 계산
            List<BigDecimal> numbers = numberService.processNumbers(numberStrings);
            BigDecimal result = numberService.calculateSum(numbers);

            // 4. 결과 출력
            IOService.printResult(result);
        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("오류 발생: " + e.getMessage());
        }
    }
}