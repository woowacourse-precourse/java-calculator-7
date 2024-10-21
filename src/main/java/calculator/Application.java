package calculator;

public class Application {
    public static void main(String[] args) {

        AppInitializer appInitializer = new AppInitializer();
        Executor executor = appInitializer.initialize();

        executor.executeCalculator();
    }
}

