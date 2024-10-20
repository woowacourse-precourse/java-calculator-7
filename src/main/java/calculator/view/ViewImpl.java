package calculator.view;

public class ViewImpl implements View {
    @Override
    public void print(int sumResult) {
        System.out.println("결과 : " + sumResult);
    }
}
