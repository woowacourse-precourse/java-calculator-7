package calculator.domain;

public class Calculator {

    private final Prompt prompt;

    public Calculator(Prompt prompt) {
        this.prompt = prompt;
    }

    public int sum() {
        return this.prompt
                .extractInteger()
                .stream()
                .reduce(0, Integer::sum);
    }

}
