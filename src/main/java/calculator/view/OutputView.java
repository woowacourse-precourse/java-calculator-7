package calculator.view;

public class OutputView {

    private OutputView() {
    }

    public static void getOutput(int sum) {
        StringBuilder result = new StringBuilder();
        System.out.println(result.append(ViewMessages.OUTPUT_MESSAGE).append(sum).toString());
    }
}
