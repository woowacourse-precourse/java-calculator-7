package calculator.util;

import static calculator.constant.CalculatorMessageConst.OUTPUT_GUIDE_MESSAGE;
import static calculator.constant.CalculatorMessageConst.START_ADDITION_CALCULATOR_GUIDE_MESSAGE;

public class CalculatorUtil {
    // 덧셈용 계산기 시작 가이드 메시지
    public static void printAdditionCalculatorStartGuideMessage() {
        System.out.println(START_ADDITION_CALCULATOR_GUIDE_MESSAGE);
    }

    // 결과 출력 메시지
    public static void printOutputGuideMessage(int result) {
        System.out.println(OUTPUT_GUIDE_MESSAGE + result);
    }
}
