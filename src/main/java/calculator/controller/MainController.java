package calculator.controller;

import calculator.view.OutView;

public class MainController {
    private static final OutView outView=OutView.getInstance();
    private static final ViewController viewController=ViewController.getInstance();
    private static final CalculatorController calculatorController=CalculatorController.getInstance();
    public static void run(){
        viewController.printGuidanceMessage();
        String text = viewController.getInputText();
        calculatorController.calculator(text);
    }
}