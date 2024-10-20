package calculator.io.read;

public class SingleLineReader implements Reader<String> {

    @Override
    public String read() {
        String read = camp.nextstep.edu.missionutils.Console.readLine();
        camp.nextstep.edu.missionutils.Console.close();
        return read;
    }

}
