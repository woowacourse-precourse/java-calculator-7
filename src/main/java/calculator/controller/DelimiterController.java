package calculator.controller;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.Delimiter;
import calculator.model.InputData;

public class DelimiterController {
    public Delimiter createDelimiterPart(InputData inputData){
        if(inputData.isDelimiter()) {
            return new CustomDelimiter(inputData.convertDelimiterPart());
        }

        return new DefaultDelimiter();
    }
}
