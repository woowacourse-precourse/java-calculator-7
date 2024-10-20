package calculator.model;

import calculator.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class Arithmetic {
    private List<Integer> arithmetic;

    public Arithmetic(Delimiter delimiter, InputData inputData) {
        if(inputData.isDelimiter()){
            validateWithCustomDelimiter(inputData);
        }
        if(!inputData.isDelimiter()){
            validateWithDefaultDelimiter(inputData);
        }
        this.arithmetic = splitArithmetic(delimiter, inputData.convertCalculatorPart());
    }

    public void validateWithDefaultDelimiter(InputData inputData){
        if (!inputData.convertCalculatorPart().matches("^[0-9,:]*$")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT.getError());
        }
    }

    public void validateWithCustomDelimiter(InputData inputData){

    }

    public List<Integer> splitArithmetic(Delimiter delimiter, String calculatorPart) {
        List<String> temp = Arrays.stream(
                        calculatorPart.split("[" + new DefaultDelimiter().getDelimiter() + "]"))
                .toList();

        if (delimiter.getClass() == CustomDelimiter.class) {
            temp = temp.stream()
                    .flatMap(str -> Arrays.stream(str.split("[" + delimiter.getDelimiter() + "]")))
                    .toList();
        }

        return temp.stream().map(Integer::parseInt).toList();
    }

    public List<Integer> getArithmetic() {
        return arithmetic;
    }

}
