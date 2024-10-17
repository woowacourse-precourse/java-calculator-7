package calculator.view;

import java.util.List;

import calculator.model.Command;
import calculator.model.Number;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Command readCommand() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Command.from(Console.readLine());
    }

    public List<Number> readNumbers() {
        Command command = readCommand();
        return command.extractNumbers();
    }
}
