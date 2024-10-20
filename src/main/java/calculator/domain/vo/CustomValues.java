package calculator.domain.vo;

import calculator.domain.vo.exception.NullEmptyException;

public record CustomValues(String value) {

    public CustomValues {
        validateCustomValue(value);
    }

    private void validateCustomValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new NullEmptyException();
        }
    }
}
