package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String ORIGINAL_SPLITTER_REGEX = ",|:";

    public static void main(String[] args) {
        String input = Console.readLine();
        String[] splitString = input.split(ORIGINAL_SPLITTER_REGEX);
        int sum = 0;
        if(splitString.length > 1){
            for (String s : splitString) {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println("결과 : " + sum);
    }
}
