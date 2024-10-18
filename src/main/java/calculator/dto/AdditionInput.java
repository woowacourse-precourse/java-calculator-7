package calculator.dto;

public record AdditionInput(String input) {

    public AdditionInput {
        validateInput(input);
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }
}