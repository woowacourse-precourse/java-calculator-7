package calculator.controller;

import calculator.domain.DelimiterExtractor;
import calculator.domain.DelimiterResult;
import calculator.domain.DelimiterTokenizer;
import calculator.domain.ResultCalculator;
import calculator.global.OutputMessage;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

/**
 * 문자열 계산기 Controller
 */
public class StringCalculator {
    private InputView inputView;     // 콘솔 입력
    private OutputView outputView;      // 콘솔 출력
    private DelimiterExtractor delimiterExtractor;      // 구분자 추출 객체
    private DelimiterTokenizer delimiterTokenizer;      // 구분자를 기준으로 문자를 분리하는 객체
    private ResultCalculator resultCalculator;      // 결과 값 계산 객체

    public StringCalculator(InputView inputView, OutputView outputView, DelimiterExtractor delimiterExtractor,
                            DelimiterTokenizer delimiterTokenizer, ResultCalculator resultCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.delimiterExtractor = delimiterExtractor;
        this.delimiterTokenizer = delimiterTokenizer;
        this.resultCalculator = resultCalculator;
    }

    public void run() {
        // "덧셈할 문자열을 입력해 주세요." 출력
        outputView.println(OutputMessage.INPUT_MESSAGE);

        // 문자열 입력
        String input = inputView.getInput();

        // 공백("")인 경우 결과값은 0
        if(input.isEmpty()){
            outputView.printResult(0L);
            return;
        }

        // 구분자 추출, 기존 문자열의 구분자 부분 제거
        DelimiterResult delimiterResult = delimiterExtractor.getDelimiters(input);

        // 구분자로 문자열 토큰 단위 후 Integer 리스트로 추출
        List<Integer> numbers = delimiterTokenizer.getNumbers(delimiterResult);

        // Integer 리스트에서 전체 합을 계산
        long result = resultCalculator.getSum(numbers);

        // 결과 값 출력
        outputView.printResult(result);
    }
}
