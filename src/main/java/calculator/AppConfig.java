package calculator;

import calculator.IO.InputService;

public class AppConfig {
    private static final AppConfig appConfig = new AppConfig();
    private InputService inputService;

    private AppConfig() {}

    public static AppConfig getInstance() {
        return appConfig;
    }

    public InputService getInputService() {
        if (inputService == null)
            inputService = new InputService();

        return inputService;
    }
}
