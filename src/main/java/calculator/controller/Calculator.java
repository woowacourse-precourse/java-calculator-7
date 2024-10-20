package calculator.controller;

import calculator.model.PatternType;
import calculator.model.StringAdder;
import calculator.model.StringType;
import calculator.viewer.CalculatorViewer;

public class Calculator {
    private StringAdder stringAdder;
    private CalculatorViewer calculatorViewer;
    private StringType stringType;

    public Calculator(StringAdder stringAdder, CalculatorViewer calculatorViewer, StringType stringType){
        this.stringAdder = stringAdder;
        this.calculatorViewer = calculatorViewer;
        this.stringType = stringType;
    }

    public void runCalculator() throws IllegalArgumentException{
        String userInput = calculatorViewer.readUserInput();
        PatternType patternType = stringType.findPatternType(userInput);

        String regex = null;
        switch (patternType){
            case DEFAULT_PATTERN -> regex = "[,:]";
            case CUSTOM_PATTERN -> regex = ""+userInput.charAt(2);
            case INVALID_PATTERN -> throw new IllegalArgumentException("ERROR: invalid argument");
        }
        String s = userInput.replaceAll("//.\\\\n", "");
        long sum = stringAdder.addString(s, regex);

        calculatorViewer.printResult(sum);
    }
}
