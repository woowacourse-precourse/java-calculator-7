package calculator;


import calculator.splitter.AbstractDelimiterSplitter;
import calculator.splitter.CustomDelimiterSplitter;
import calculator.splitter.DefaultDelimiterSplitter;
import calculator.splitter.DelegateDelimiterSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(splitters());
        Accumulator accumulator = new Accumulator(splitter);

        OutputView.renderResult(accumulator.sum(InputView.readInput()));
    }

    private static List<AbstractDelimiterSplitter> splitters() {
        return List.of(new CustomDelimiterSplitter(0), new DefaultDelimiterSplitter(1));
    }
}
