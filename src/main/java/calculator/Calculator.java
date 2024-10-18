package calculator;

import calculator.view.InputView;

public class Calculator {

    public Calculator() {
    }

    public void start() {
        String input = InputView.input();
//        System.out.println("input = " + input);

        String[] results = getNumberLists(input);
        for (String result : results) {
            System.out.println("result = " + result);
        }
    }

    private String[] getNumberLists(String str) {
        return str.split("[,:]");
    }



}
