package calculator.domain;

public abstract class Input {

    protected final String text;

    protected Input(String text) {
        this.text = text;
    }

    public abstract Long[] createCalculationInputs();
}
