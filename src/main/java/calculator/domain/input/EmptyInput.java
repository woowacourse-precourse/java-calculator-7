package calculator.domain.input;

public class EmptyInput extends Input {

    private EmptyInput(String text) {
        super(text);
    }

    public static Input from(String text) {
        return new EmptyInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        return new Long[]{0L};
    }

}
