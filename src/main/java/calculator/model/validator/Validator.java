package calculator.model.validator;

import calculator.model.dto.DelimiterInputData;

public interface Validator {
    void validate();

    DelimiterInputData validatedData();

}
