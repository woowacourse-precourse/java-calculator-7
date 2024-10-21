package calculator.calculator;

import calculator.splitter.AbstractDelimiterSplitter;
import calculator.splitter.CustomDelimiterSplitter;
import calculator.splitter.DefaultDelimiterSplitter;
import java.util.List;

public class SplitterFixture {
    public static List<AbstractDelimiterSplitter> defaultSplitter() {
        return List.of(new DefaultDelimiterSplitter(1), new CustomDelimiterSplitter(0));
    }
}
