package calculator;

import calculator.config.ExecutorConfig;
import calculator.executor.Executor;

public class Application {

    public static void main(String[] args) {
        Executor executor = new ExecutorConfig().executor();
        executor.run();
    }

}
