package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Calculator {

    private int calculate(String target) {
        Splitter machine = new Splitter();
        int result = 0;

        ArrayList<Integer> numbers = machine.splitTarget(target);

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    public int putTargetAndCalculate() {
        String target = Console.readLine();

        return calculate(target);
    }
}
