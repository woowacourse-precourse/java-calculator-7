package calculator.input.strategy;

import java.util.Scanner;

public class ConsoleInputStrategy implements InputStrategy{
    @Override
    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
