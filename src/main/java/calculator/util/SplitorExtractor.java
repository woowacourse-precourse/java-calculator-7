package calculator.util;

import calculator.InputString;
import calculator.splitor.BasicSplitor;
import calculator.splitor.CustomSplitor;
import calculator.splitor.Splitor;

public class SplitorExtractor {
    public Splitor extractSplitor(InputString input) {
        // 커스텀 구분자를 지정했는지 확인
        if (input.containsCustomSeperator()) {
            return new CustomSplitor();
        } else {
            return new BasicSplitor();
        }
    }
}
