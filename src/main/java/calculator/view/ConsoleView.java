package calculator.view;

public class ConsoleView implements UserView {
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
