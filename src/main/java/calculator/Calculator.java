package calculator;

public class Calculator {
    private int result;

    public Calculator() {}

    public void run(){
        Output.printUserInput();

    }

    public void end(){
        Output.printResult(this.result);
    }
}
