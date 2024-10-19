package calculator.io;

public class ConsoleInputHandler implements InputHandler {

    @Override
    public String getUserInput() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
