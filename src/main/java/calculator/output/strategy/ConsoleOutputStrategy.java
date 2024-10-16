package calculator.output.strategy;

public class ConsoleOutputStrategy implements OutputStrategy {
    @Override
    public void output(String str) {
        System.out.println("결과 : " + str);
    }
}
