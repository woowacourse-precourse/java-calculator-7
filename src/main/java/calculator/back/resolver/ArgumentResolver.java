package calculator.back.resolver;

import calculator.back.dto.RequestDTO;
import calculator.front.input.TotalDelimitedInput;

public class ArgumentResolver {

    public RequestDTO resolve(TotalDelimitedInput totalDelimitedInput) {
        return new RequestDTO(totalDelimitedInput.getDelimiters(), totalDelimitedInput.getInputWithDelimiters());
    }
}
