package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        FrontController frontController = initFrontController();
        frontController.run();
    }

    public static FrontController initFrontController() {
        return new FrontController();
    }
}
