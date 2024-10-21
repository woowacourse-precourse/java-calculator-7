package calculator;

public class Caculator {
    private String inputString;
    private String[] numbers;
    private Input input = new Input();
    private Delimiter delimiter = new Delimiter();

    public Caculator() {
    }

    public void run() {
        setInputString();
        System.out.println(inputString);

        setNumbers();
        validateNumbers(numbers);
    }

    private void setInputString() {
        input.setString();
        inputString = input.getString();
    }

    private void setNumbers() {
        delimiter.parseInput(inputString);
        numbers = delimiter.getNumbers();
    }

    private void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
        }
    }
}
