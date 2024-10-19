package calculator.exception.basic;

public interface BasicErrorCode {
    CausedBy causedBy();
    String getExplainError();
}
