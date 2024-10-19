package calculator.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    public void output(int num){
        System.out.println("결과 : "+num);
    }
}
