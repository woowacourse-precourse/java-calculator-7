package calculator;

public class Printer {
    long output;
    public Printer(Adder adder) {
        output=adder.getOutput();
    }

    public void  PrintOutput() {
        System.out.println(output);
    }
}
