package calculator.Model;

public class Calculator {
    public void checkOverflow(int nowNumber, int sum) {
        if (nowNumber > 0 && sum > Integer.MAX_VALUE-nowNumber) {
            throw new IllegalArgumentException("표현할 수 있는 최대치를 초과하였습니다.");
        }
        if (nowNumber < 0 && sum < Integer.MIN_VALUE - nowNumber) {
            throw new IllegalArgumentException("표현할 수 있는 최소치를 초과하였습니다.");
        }
    }

    public int calcSum(Number number) {
        int sum = 0;

        int numberSize = number.size();
        for (int i=0; i<numberSize; i++) {
            int nowNumber = number.get(i);
            checkOverflow(nowNumber, sum);
            sum += nowNumber;
        }

        return sum;
    }

    public void turnOn() {
        String inputText = Input.consoleInput();

        Number number = new Number();
        number.getInputText(inputText);

        int sum = calcSum(number);
        Output.consoleOutput(sum);
    }
}
