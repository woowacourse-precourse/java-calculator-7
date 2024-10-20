package calculator;

import calculator.service.CalculatorService;
import calculator.service.InputService;
import calculator.service.OutputService;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        // 사용자에게 문자열을 입력
        String inputString = InputService.input();
        // 입력받은 문자열에서 커스텀 구분자를 추출
        Map<String, String> extractedMap = InputService.extractCustomDelimiter(inputString);

        // 인자로 보내진 문자열과 구분자로 숫자 추출 후 더함. 더해진 값 반환
        int calculatedInt = CalculatorService.extractAndCalculate(extractedMap);

        // 반환된 결과값 출력
        OutputService.print(calculatedInt);
    }
}
