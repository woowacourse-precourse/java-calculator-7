package calculator.service;

import calculator.view.CalculatorView;

public class CalculatorService {

    public Boolean checkZero(String input) {
        if (input == null || input.isEmpty()) {
            CalculatorView.printResult(0);
            return true;
        }
        return false;
    }

    static String seperate = ":|,";

    public String checkSeperate(String input) {
        if (input.startsWith("\"//") && input.contains("\\n")) {
            int index = input.indexOf("\\n");
            for (int i = 3; i < index; i++) {
                String ch = input.substring(i, i + 1);
                seperate = seperate + "|" + ch;
            }
            input = input.substring(index + 2, input.length()-1);
        }
        return input;
    }


}
