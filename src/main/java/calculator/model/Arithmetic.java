package calculator.model;

import calculator.util.ErrorMessage;
import calculator.util.Limit;
import calculator.util.Message;
import calculator.util.Regex;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Arithmetic {
    private List<Integer> arithmetic;

    public Arithmetic(Delimiter delimiter, InputData inputData) {
        if (inputData.isDelimiter()) {
            validateWithCustomDelimiter(delimiter, inputData);
        }
        if (!inputData.isDelimiter()) {
            validateWithDefaultDelimiter(inputData);
        }

        List<Integer> number = splitArithmetic(delimiter, inputData.convertCalculatorPart());

        validateNumbers(number);

        this.arithmetic = number;
    }

    public void validateWithDefaultDelimiter(InputData inputData) {
        if (!inputData.convertCalculatorPart()
                .matches(Regex.ARITHMETIC_WITH_DEFAULT_DELIMITER.getRegex())) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT.getError());
        }
    }

    public void validateWithCustomDelimiter(Delimiter delimiter, InputData inputData) {
        if (!inputData.convertCalculatorPart()
                .matches(Regex.ARITHMETIC_WITH_CUSTOM_DELIMITER_PREFIX.getRegex()
                        + new DefaultDelimiter().getDelimiter()
                        + delimiter.getDelimiter()
                        + Regex.ARITHMETIC_WITH_CUSTOM_DELIMITER_SUFFIX.getRegex())) {
            throw new IllegalArgumentException(ErrorMessage.ARITHMETIC_WITH_CUSTOM_DELIMITER_FORMAT.getError());
        }
    }

    public void validateNumbers(List<Integer> numbers) {
        if (numbers.size() > Limit.MAX_DIGIT_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ARITHMETIC_LENGTH_LIMIT.getError());
        }

        if (numbers.stream()
                .anyMatch(number -> number < Limit.MIN_NUMBER.getValue() || number > Limit.MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.ARITHMETIC_RANGE_LIMIT.getError());
        }
    }

    public List<Integer> splitArithmetic(Delimiter delimiter, String calculatorPart) {
        List<String> temp = Arrays.stream(
                        calculatorPart
                                .split(Regex.OPEN.getRegex()
                                        + new DefaultDelimiter().getDelimiter()
                                        + Regex.CLOSE.getRegex()))
                .map(s -> s.replaceAll(Regex.WHITE_SPACE.getRegex(), Message.BLANK.getSentence()))
                .map(s ->
                        Optional.of(s).filter(str ->
                                !str.isEmpty()).orElse(Message.DEFAULT_NUMBER.getSentence()))
                .toList();

        if (delimiter.getClass() == CustomDelimiter.class) {
            temp = temp.stream()
                    .flatMap(str ->
                            Arrays.stream(
                                    str.split(
                                    Regex.OPEN.getRegex()
                                    + delimiter.getDelimiter()
                                    + Regex.CLOSE.getRegex())))
                    .map(String::trim)
                    .map(s ->
                            Optional.of(s).filter(str ->
                                    !str.isEmpty()).orElse(Message.DEFAULT_NUMBER.getSentence()))
                    .toList();
        }

        return temp.stream().map(Integer::parseInt).toList();
    }

    public List<Integer> getArithmetic() {
        return arithmetic;
    }

}
