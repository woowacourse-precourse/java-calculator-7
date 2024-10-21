package calculator.output;

public class OutputProcessor {
    private static OutputProcessor instance;

    private OutputProcessor() {

    }

    public static OutputProcessor getInstance() {
        if (instance == null) {
            instance = new OutputProcessor();
        }

        return instance;
    }

    public void write(int result) {
        System.out.println("결과 : " + result);
    }
}
