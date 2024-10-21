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
        if (input.startsWith("//") && input.contains("\\n")) {
            int index = input.indexOf("\\n");
            for (int i = 2; i < index; i++) {
                String ch = input.substring(i, i + 1);
                seperate = seperate + "|" + ch;
            }
            input = input.substring(index + 2, input.length());
        }
        return input;
    }
    static int answer;

    public void exceptionFirst(String[] afterSplit) {
        for(String temp : afterSplit) {
            try{
                int number = Integer.parseInt(temp);
                answer+=number;
                if (number < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }


    public String[] splitInput(String input) {

        return input.split(seperate);
    }


    public void mainController(String input) {
        if (checkZero(input)) {
            return;
        }
        input=checkSeperate(input);
        String[] onlyNumber=splitInput(input);

        exceptionFirst(onlyNumber);
        CalculatorView.printResult(answer);

    }




}
