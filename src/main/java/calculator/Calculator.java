package calculator;

public class Calculator {

    private Input input;

    public Calculator() {
        this.input = new Input();
    }

    public void run() {
        String inputString = input.input();
    }
}
