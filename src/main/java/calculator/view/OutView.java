package calculator.view;

import calculator.controller.MainController;
import calculator.global.Utils;

public class OutView {
    private static OutView outView;
    public static OutView getInstance(){
        if (outView == null){
            outView = new OutView();
        }
        return outView;
    }

    public void inputMessage(){
        System.out.println(Utils.INPUT_MESSAGE);
    }
}
