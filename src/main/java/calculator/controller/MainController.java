package calculator.controller;

import calculator.view.OutView;

public class MainController {
    private static final OutView outView=OutView.getInstance();

    public static void run(){
        outView.inputMessage();
    }
}
