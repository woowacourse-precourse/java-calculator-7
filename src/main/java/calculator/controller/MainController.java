package calculator.controller;

import calculator.domain.*;
import calculator.view.Input;
import calculator.view.Output;

import java.util.List;

public class MainController {
    public void main(){
        CalculatedValue calculatedValue = createCalculatedValue();
        Divider divider = createDivider();
        CustomDividerFinder customDividerFinder = createCustomDividerFinder();
        updateCustomDivider(calculatedValue, divider, customDividerFinder);

        NumberParser numberParser = createNumberParser(divider);



        int result = getCalculatedResult(calculatedValue, numberParser);

        Output.printResult(result);

    }


    private Integer getCalculatedResult(CalculatedValue calculatedValue,NumberParser numberParser){
        System.out.println("wefwef"+calculatedValue.getValue());
        List<Integer> numbers = getNumberFromNumberParser(calculatedValue,numberParser);
        return AddCalculator.add(numbers);
    }


    private List<Integer> getNumberFromNumberParser(CalculatedValue calculatedValue,NumberParser numberParser){
        return numberParser.parse(calculatedValue);
    }

    private NumberParser createNumberParser(Divider divider) {
        return new NumberParser(divider);
    }

    //todo 이거를 클래스에서 처리하기 위해서는? - 서비스로
    private void updateCustomDivider(CalculatedValue calculatedValue, Divider divider,CustomDividerFinder customDividerFinder){
        try{
            customDividerFinder.findCustomDividers(calculatedValue,divider);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
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

}
