package calculator;

public class CalculatorModel {
    private final Util util = new Util();

    public Long[] changeStringtoLongOperandArray(String userInput) {
        Long[] operandArray = new Long[0];
        if (!util.checkforInvalidPrefix(userInput)) {
            throw new IllegalArgumentException("잘못된 입력값입니다: " + userInput);
        }

        return operandArray;
    }


}
