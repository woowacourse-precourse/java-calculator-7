package calculator.view;

public class CalculatorOutputView {

    public void printInstruction() {
        System.out.println(Message.INSTRUCTION_MESSAGE.getMessage());
    }

    public void printResult(String result) {
        System.out.println(Message.RESULT_MESSAGE.getMessage() + result);
    }
}
