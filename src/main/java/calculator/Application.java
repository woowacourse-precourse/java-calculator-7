package calculator;

import calculator.controller.Process;
import calculator.exception.SeparatorException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Process process = new Process();
            process.run();
        } catch (SeparatorException e) {
            System.out.println(e.getMessage());
        }
    }
}
