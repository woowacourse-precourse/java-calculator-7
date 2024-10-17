package calculator;

public class AppConfig {
    private static final AppConfig appConfig = new AppConfig();

    private AppConfig() {}

    public static AppConfig getInstance() {
        return appConfig;
    }
}
