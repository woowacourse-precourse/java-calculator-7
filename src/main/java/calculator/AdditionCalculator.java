package calculator;

import static calculator.constant.DelimiterConst.DEFAULT_DELIMITER_COLON;
import static calculator.constant.DelimiterConst.DEFAULT_DELIMITER_COMMA;
import static calculator.util.CalculatorUtil.printAdditionCalculatorStartGuideMessage;

import java.util.ArrayList;
import java.util.List;

public class AdditionCalculator {
    private List<Character> additionDelimiters = new ArrayList<>();
    private List<Integer> additionNumbers = new ArrayList<>();
    private String inputString;

    public AdditionCalculator() {
        // 덧셈용 계산기에 기본 구분자를 등록한다.
        additionDelimiters.add(DEFAULT_DELIMITER_COMMA);
        additionDelimiters.add(DEFAULT_DELIMITER_COLON);
    }

    public void runAdditionCalculator() {
        printAdditionCalculatorStartGuideMessage();

    }
}
