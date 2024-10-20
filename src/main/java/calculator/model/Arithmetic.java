package calculator.model;

import calculator.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class Arithmetic {
    private List<Integer> arithmetic;

    public Arithmetic(Delimiter delimiter, InputData inputData) {
        if(inputData.isDelimiter()){
            validateWithCustomDelimiter(delimiter, inputData);
        }
        if(!inputData.isDelimiter()){
            validateWithDefaultDelimiter(inputData);
        }

        List<Integer> number = splitArithmetic(delimiter, inputData.convertCalculatorPart());

        validateNumbers(number);

        this.arithmetic = number;
    }

    public void validateWithDefaultDelimiter(InputData inputData){
        if (!inputData.convertCalculatorPart().matches("^[0-9\\-,:]*$")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT.getError());
        }
    }

    public void validateWithCustomDelimiter(Delimiter delimiter, InputData inputData){
        if (!inputData.convertCalculatorPart()
                .matches("^[0-9\\-" + new DefaultDelimiter().getDelimiter() + delimiter.getDelimiter() + "]*$")) {
            throw new IllegalArgumentException(ErrorMessage.ARITHMETIC_WITH_CUSTOM_DELIMITER_FORMAT.getError());
        }
    }

    public void validateNumbers(List<Integer> numbers){
        if (numbers.size() > 30){
            throw new IllegalArgumentException(ErrorMessage.ARITHMETIC_LENGTH_LIMIT.getError());
        }

        if (numbers.stream().anyMatch(number -> number < 0 || number > 1000)){
            throw new IllegalArgumentException(ErrorMessage.ARITHMETIC_RANGE_LIMIT.getError());
        }
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
