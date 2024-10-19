package calculator;

public class Input {
    private final String input;

    public Input() {
        this.input = readInput();
    }

    private String readInput() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public String getInput() {
        return input;
    }
}
