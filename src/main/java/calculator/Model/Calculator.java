package calculator.Model;

public class Calculator {
    private int sum = 0;

    public void checkOverflow(int nowNumber) {
        if (nowNumber > 0 && sum > Integer.MAX_VALUE-nowNumber) {
            throw new IllegalArgumentException("표현할 수 있는 최대치를 초과하였습니다.");
        }
        if (nowNumber < 0 && sum < Integer.MIN_VALUE - nowNumber) {
            throw new IllegalArgumentException("표현할 수 있는 최소치를 초과하였습니다.");
        }
    }

    public int calcSum(Input input) {
        int numberSize = input.size();
        for (int i=0; i<numberSize; i++) {
            int nowNumber = input.get(i);
            checkOverflow(nowNumber);
            sum += nowNumber;
        }

        return sum;
    }

    public void turnOn() {
        Input input = new Input();
        String inputText = input.consoleInput();
        input.getInputText(inputText);

        int sum = calcSum(input);
        Output.consoleOutput(sum);
    }
}
