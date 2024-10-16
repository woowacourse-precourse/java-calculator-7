package calculator;

public class Calculator {

    private final SeparationProcessor separationProcessor;

    public Calculator (SeparationProcessor separationProcessor){
        this.separationProcessor = separationProcessor;
    }

    public int sum(String cmd){
        String[] rawNumbers = separationProcessor.split(cmd);

        int sum = 0;
        for(String rawNum : rawNumbers){
            sum += Integer.parseInt(rawNum);
        }

        return sum;
    }
}
