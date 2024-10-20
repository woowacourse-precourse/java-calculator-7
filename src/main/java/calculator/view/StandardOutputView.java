package calculator.view;

public class StandardOutputView implements OutputView {

    @Override
    public void print(String output) {
        System.out.println("결과 : " + output);
    }
}
