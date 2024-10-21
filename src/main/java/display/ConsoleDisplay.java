package display;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleDisplay implements Display{
    String input;
    @Override
    public String input(){
        return setInput();
    }

    private String setInput(){
        return input = Console.readLine();
    }

    public String getInput(){
        return input;
    }

    @Override
    public void output(String output){
        setOutput(output);
    }

    private void setOutput(String output){
        System.out.print(output);
    }
}
