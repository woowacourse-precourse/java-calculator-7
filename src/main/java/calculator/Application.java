package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        
        NumbersParser parser = new NumbersParser(input);
        long sum = 0;
        for (int num : parser.getNumbers()) {
            sum += num;
        }
        
        System.out.print("결과 : " + sum);
    }
}
