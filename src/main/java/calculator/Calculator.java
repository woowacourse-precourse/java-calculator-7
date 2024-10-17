package calculator;

public class Calculator {

    private final Operands operands;

    public Calculator() {
        this.operands = new Operands();
    }

    public void enter(String input) {
        BasicNumberConverter converter = new BasicNumberConverter(input);
        converter.convert();
    }

}
