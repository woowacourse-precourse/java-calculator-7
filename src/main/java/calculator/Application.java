package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.splitprocess.DelimiterParser;
import calculator.splitprocess.StringSplitter;
import calculator.calculate.CalculateSum; // CalculateSum 클래스 임포트

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            String input = inputView.getInput(); // 사용자 입력 받기
            String delimiter = DelimiterParser.getDelimiter(input); // 구분자 추출
            int[] numbers = StringSplitter.splitString(input, delimiter); // 숫자 추출
            int sum = CalculateSum.calculateSum(numbers); // 합계 계산
            outputView.printOutputMessage(sum); // 결과 출력
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage()); // 오류 메시지 출력
        }
    }
}
