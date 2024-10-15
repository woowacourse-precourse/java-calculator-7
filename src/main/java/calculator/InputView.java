package calculator;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Command readCommand() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Command.from(Console.readLine());
    }

    public List<Integer> readNumbers() {
        Command command = readCommand();
        String splitter = String.format("[%s,:]", command.header());
        return Arrays.stream(command.content().split(splitter)).mapToInt(Integer::parseInt).boxed().toList();
    }
}
