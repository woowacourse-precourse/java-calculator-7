package calculator.exception.basic;

public class GlobalException extends IllegalArgumentException {
    private final BasicErrorCode basicError;

    public GlobalException(BasicErrorCode basicError) {
        super(basicError.causedBy().message());
        this.basicError = basicError;
    }

    @Override
    public String toString() {
        return "name: " + basicError.causedBy().name() + " message: " + basicError.getExplainError();
    }
}
