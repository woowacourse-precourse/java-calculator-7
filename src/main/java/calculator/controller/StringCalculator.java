package calculator.controller;

import calculator.domain.DelimiterExtractor;
import calculator.domain.DelimiterTokenizer;
import calculator.domain.DelimiterResult;
import calculator.domain.ResultCalculator;
import calculator.global.OutputMessage;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class StringCalculator {
    private InputView inputView;
    private OutputView outputView;
    private DelimiterExtractor delimiterExtractor;
    private DelimiterTokenizer delimiterTokenizer;
    private ResultCalculator resultCalculator;

    public StringCalculator(InputView inputView, OutputView outputView, DelimiterExtractor delimiterExtractor,
                            DelimiterTokenizer delimiterTokenizer, ResultCalculator resultCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.delimiterExtractor = delimiterExtractor;
        this.delimiterTokenizer = delimiterTokenizer;
        this.resultCalculator = resultCalculator;
    }

    public void run(){
        // "덧셈할 문자열을 입력해 주세요." 출력
        outputView.println(OutputMessage.INPUT_MESSAGE);

        // 문자열 입력
        String input = inputView.getInput();

        // 구분자 추출, 기존 문자열의 구분자 부분 제거
        DelimiterResult delimiterResult = delimiterExtractor.getDelimiters(input);

        // 구분자로 문자열 토큰 단위 후 Integer 리스트로 추출
        List<Integer> numbers = delimiterTokenizer.getNumbers(delimiterResult);



    }
}
