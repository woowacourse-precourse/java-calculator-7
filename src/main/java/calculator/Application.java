package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationContext applicationContext = new ApplicationContext();
        ApplicationRunner applicationRunner = new ApplicationRunner(applicationContext);
        applicationRunner.run();
    }
}
