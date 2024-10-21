package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = InputView.printInputView();
        List<Integer> integers = Filter.doFilter(inputString);
        // TODO: 검증? 필터?를 거쳐서 InputString 에서 List<Integer> 형태로 변환하여 calculate 의 파라미터로 넣기
        String output = Calculator.calculate(integers);
        OutputView.printOutputView(output);



    }
}
