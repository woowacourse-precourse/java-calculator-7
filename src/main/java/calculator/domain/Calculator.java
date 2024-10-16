package calculator.domain;

import calculator.domain.prompt.Prompt;

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
