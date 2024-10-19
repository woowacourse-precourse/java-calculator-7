package calculator.Controller;

import calculator.DTO.StringCalculatorDTO;
import calculator.Service.DelimiterExtractor;
import calculator.Service.InputReader;
import java.util.List;

public class StringProcessorController {
    // 의존성 주입 이후, 불변성 보장
    private final InputReader inputReader;
    private final DelimiterExtractor delimiterExtractor;

    // 생성자에서 외부로부터의 의존성 주입
    public StringProcessorController(InputReader inputReader, DelimiterExtractor delimiterExtractor) {

        this.inputReader = inputReader;
        this.delimiterExtractor = delimiterExtractor;
    }

    // 전체 프로세스 조율
    public void process() {
        // 입력을 받아서 DTO 생성
        StringCalculatorDTO inputDTO = inputReader.read();

        // 문자열을 기본 구분자를 기준으로 분리하는 로직 호출
        List<String> afterDefaultExtractor = delimiterExtractor.extractDelimiter(inputDTO);
        inputDTO.setDetachedInput(afterDefaultExtractor);

        // 기본 구분자로 분리된 문자열을 커스텀 구분자를 기준으로 또 다시 분리하는 로직 호출
        List<String> afterCustomExtractor = CustomDelimiterExtractor.extractDelimiter(inputDTO);
    }


}
