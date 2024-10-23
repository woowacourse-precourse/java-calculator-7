package calculator;

import static calculator.View.*;
import static calculator.SumController.*;

public class Application {
    public static void main(String[] args) throws Exception {
        // TODO: 프로그램 구현
        try {
            outputValue(checkValue(inputValue()));
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }
}
