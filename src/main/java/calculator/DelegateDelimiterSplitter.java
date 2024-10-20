package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DelegateDelimiterSplitter {

    private final List<AbstractDelimiterSplitter> delimiterSplitters;

    public DelegateDelimiterSplitter(List<AbstractDelimiterSplitter> delimiterSplitters) {
        this.delimiterSplitters = new ArrayList<>(delimiterSplitters);
        Collections.sort(this.delimiterSplitters);
    }

    public List<String> split(String value) {
        for (AbstractDelimiterSplitter delimiterSplitter : delimiterSplitters) {
            SplitResult result = delimiterSplitter.split(value);
            if (result.isSuccess()) {
                return result.result();
            }
        }

        throw new IllegalArgumentException("처리 할 수 없는 패턴입니다.");
    }
}
