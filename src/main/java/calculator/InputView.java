package calculator;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCommand() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> readNumbers() {
        String command = readCommand();
        return Arrays.stream(command.split("[,:]")).mapToInt(Integer::parseInt).boxed().toList();
    }
}
