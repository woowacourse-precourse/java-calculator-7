package calculator;

import calculator.constant.Message;

public class Application {
    public static void main(String[] args) {
        StringAdder adder = new StringAdder();

        System.out.println(Message.GUIDE_MESSAGE);
        adder.setInputValue();
        int result = adder.calculate();
        System.out.printf("%s%d%n", Message.RESULT_MESSAGE, result);
    }
}
