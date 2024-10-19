package calculator.model.validator;

import calculator.model.Dto.DelimiterInputData;

public interface Validator {
    void validate();

    DelimiterInputData validatedData();

}
