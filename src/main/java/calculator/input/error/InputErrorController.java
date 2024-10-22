package calculator.input.error;

public class InputErrorController extends IllegalArgumentException {

    public InputErrorController(InputErrorType inputError) {
        super(inputError.getMessage());
    }

}
