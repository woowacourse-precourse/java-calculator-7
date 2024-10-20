package calculator;

import java.util.List;
import parser.DelimiterExtractor;
import parser.NumberExtractor;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        NumberExtractor numberExtractor = new NumberExtractor();
        Calculator calculator = new Calculator();

        // 사용자로부터 입력 받기
        String input = inputView.getInput();

        // 구분자 추출
        String delimiter = delimiterExtractor.extractDelimiter(input);

        // 숫자 추출
        List<Integer> numbers = numberExtractor.extractNumbers(input, delimiter);

        // 숫자들의 합 계산
        int result = calculator.add(numbers);

        // 결과 출력
        outputView.printResult(result);

    }
}
