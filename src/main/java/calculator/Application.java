package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String[] originalSplitters = {",", ":"};

    public static void main(String[] args) {
        String input = Console.readLine();
        InputSplitter inputSplitter = new InputSplitter(input);
    }
}
