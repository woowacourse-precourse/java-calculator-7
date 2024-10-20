package calculator;

import calculator.command.CommandReader;
import calculator.command.DelimiterLine;
import calculator.command.NumbersLine;
import calculator.number.NumbersReader;
import calculator.number.rule.PositiveNumbersRule;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        print("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        Console.close();
        CommandReader commandReader = createCommandReader();
        DelimiterLine delimiterLine = commandReader.readDelimiter(userInput);
        NumbersLine numbersLine = commandReader.readNumbers(userInput);

        MyCalculator calculator = createPositiveNumbersCalculator();
        int result = calculator.calculate(delimiterLine, numbersLine);
        print("결과 : ".concat(String.valueOf(result)));
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static CommandReader createCommandReader() {
        return new CommandReader();
    }

    private static MyCalculator createPositiveNumbersCalculator() {
        return new MyCalculator(createPositiveNumberReader());
    }

    private static NumbersReader createPositiveNumberReader() {
        return new NumbersReader(new PositiveNumbersRule());
    }
}
