package calculator.util;

import calculator.InputString;
import calculator.splitor.BasicSplitor;
import calculator.splitor.CustomSplitor;
import calculator.splitor.Splitor;

public class SplitorExtractor {
    public Splitor extractSplitor(InputString inputString) {
        // 커스텀 구분자를 지정했는지 확인
        if (inputString.containsCustomSeperator()) {
            char seperator = inputString.extractCustomSeperator();
            return new CustomSplitor(inputString, seperator);
        } else {
            return new BasicSplitor(inputString);
        }
    }
}
