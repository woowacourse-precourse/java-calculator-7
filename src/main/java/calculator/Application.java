package calculator;

import calculator.separator.CustomSeparator;
import calculator.separator.DefaultSeparator;
import calculator.separator.Separator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String line = Console.readLine();
        Separator separator = createSeparator(line);
        Calculator calculator = new Calculator(separator);
        try{
            calculator.calculate();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static Separator createSeparator(String line) {
        if (line.startsWith("//")) {
            return new CustomSeparator(line);
        }
        return new DefaultSeparator(line);
    }
}
