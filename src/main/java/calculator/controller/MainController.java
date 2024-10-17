package calculator.controller;

import calculator.domain.*;
import calculator.view.Input;
import calculator.view.Output;

import java.util.List;

public class MainController {
    public void main(){
        Divider divider = createDivider();
        CalculatedValue calculatedValue = createCalculatedValue();

        NumberParser numberParser = createNumberParser(divider);
        CustomDividerFinder customDividerFinder = createCustomDividerFinder();

        updateCustomDivider(calculatedValue, divider, customDividerFinder);
        extractNumberValue(calculatedValue,numberParser);

        int result = getCalculatedResult(calculatedValue);

        printCalculatedResult(result);
    }

    private Integer getCalculatedResult(CalculatedValue calculatedValue){
        return AddCalculator.add(calculatedValue.getNumberValueToken());
    }

    private void extractNumberValue(CalculatedValue calculatedValue,NumberParser numberParser){
        numberParser.parse(calculatedValue);
    }

    private void updateCustomDivider(CalculatedValue calculatedValue, Divider divider,CustomDividerFinder customDividerFinder){
        customDividerFinder.findCustomDividers(calculatedValue,divider);
    }

    private NumberParser createNumberParser(Divider divider) {
        return new NumberParser(divider);
    }

    private CustomDividerFinder createCustomDividerFinder(){
        return new CustomDividerFinder();
    }

    private Divider createDivider(){
        return new Divider();
    }

    private CalculatedValue createCalculatedValue(){
        return new CalculatedValue(inputStringToAdd());
    }

    private String inputStringToAdd(){
        return Input.inputStringToAdd();
    }

    private void printCalculatedResult(int result) {
        Output.printResult(result);
    }

}
