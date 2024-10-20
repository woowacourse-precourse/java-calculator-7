package calculator.util;

import calculator.InputString;
import calculator.splitor.BasicSplitor;
import calculator.splitor.CustomSplitor;
import calculator.splitor.Splitor;

import java.util.List;

public class SplitorExtractor {
    public Splitor extractSplitor(InputString inputString) {
        // 커스텀 구분자를 지정했는지 확인
        if (inputString.containsCustomSeperator()) {
            List<String> stringList = inputString.extractCustomSeperator();
            return new CustomSplitor(stringList.get(1), stringList.get(0));
        } else if (inputString.notContainsCustomSeperator()){
            return new BasicSplitor(inputString.getInputString());
        } else {
            throw new IllegalArgumentException("문자열이 '//' 또는 숫자로 시작해야 됩니다.");
        }
    }
}
