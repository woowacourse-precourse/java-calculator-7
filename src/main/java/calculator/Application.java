package calculator;

public class Application {
    public static void main(String[] args) {
        Coordinator coordinator = new Coordinator(new IOService(), new DelimiterService(), new NumberService());
        coordinator.execute();
    }
}