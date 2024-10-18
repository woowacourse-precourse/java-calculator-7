package calculator;

import calculator.view.InputView;

public class Calculator {

    public Calculator() {
    }

    public void start() {
        String input = InputView.input();
//        System.out.println("input = " + input);

        String[] results = getNumberLists(input);

        int answer = getAnswer(results);
        System.out.println("answer = " + answer);
    }

    private String[] getNumberLists(String str) {
        return str.split("[,:]");
    }

    private static int getAnswer(String[] results) {
        int answer = 0;
        for (String result : results) {
            answer += Integer.parseInt(result);
        }
        return answer;
    }



}
