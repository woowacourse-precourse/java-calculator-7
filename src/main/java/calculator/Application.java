package calculator;

import calculator.io.CustomReader;
import calculator.io.CustomWriter;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CustomWriter.printInitMessage();
        CustomReader.readLine();

    }
}
