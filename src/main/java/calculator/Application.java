package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Reader.printInputMessage();
            String input = Console.readLine();
            List<Integer> list = Parser.parse(input);
            int sum = Calculator.sum(list);
            Printer.print(sum);
        } finally {
            Console.close();
        }
    }
}
