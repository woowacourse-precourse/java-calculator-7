package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String ORIGINAL_SPLITTER_REGEX = ",|:";

    public static void main(String[] args) {
        String input = Console.readLine();
        String[] splitString = input.split(ORIGINAL_SPLITTER_REGEX);
        int sum = 0;
        if(splitString.length >= 1) {
            sum = calculateSum(splitString, sum);
        }
        System.out.println("결과 : " + sum);
    }

    private static int calculateSum(String[] splitString, int sum){
        for (String s : splitString) {
             sum += Integer.parseInt(s);
        }
        return sum;
    }
}
