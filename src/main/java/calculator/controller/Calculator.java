package calculator.controller;

import calculator.service.NumTypeResolver;
import calculator.service.Separator;
import calculator.service.Splitter;
import calculator.service.UserInput;
import calculator.service.UserOutput;
import calculator.service.adder.NumAdder;
import calculator.service.convertor.NumConverter;

public class Calculator {

    private final UserInput userInput;
    private final UserOutput userOutput;
    private final Splitter splitter;
    private final Separator separator;
    private NumConverter numConverter;
    private NumAdder numAdder;

    public Calculator() {
        userInput = new UserInput();
        userOutput = new UserOutput();
        splitter = new Splitter();
        separator = new Separator();
    }

    public void calculate() {
        userInput.readLine();
        splitter.findSplitter();
        separator.separateString();
        NumTypeResolver.resolveNumType(this);
        numConverter.convertNumber();
        numAdder.sum();
        userOutput.print();
    }

    public void setNumConverter(NumConverter numConverter) {
        this.numConverter = numConverter;
    }

    public void setNumAdder(NumAdder numAdder) {
        this.numAdder = numAdder;
    }
}
