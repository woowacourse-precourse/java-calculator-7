package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutView;

public class ViewController {
    private static ViewController viewController;
    private static InputView inputView = InputView.getInstance();
    private static OutView outView =  OutView.getInstance();

    public static ViewController getInstance(){
        if (viewController == null){
            viewController = new ViewController();
        }
        return viewController;
    }
    public void printGuidanceMessage(){
        outView.inputMessage();
    }
    public String getInputText(){
        return inputView.readLine();
    }
}
