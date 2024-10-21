package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            String input = Reader.getInput();
            List<Integer> list = Parser.parse(input);
            int sum = Calculator.sum(list);
            Printer.print(sum);
        } finally {
            Reader.close();
        }
    }
}
