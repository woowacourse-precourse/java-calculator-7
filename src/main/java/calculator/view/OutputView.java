package calculator.view;

public class OutputView {

    private OutputView(){}

    public static OutputView createOutputView(){
        return new OutputView();
    }

    public void printMessage(Output output) {
        System.out.println(output.message);
    }

    public void printMessage(Output output, int result) {
        System.out.printf(output.message, result);
    }
}
