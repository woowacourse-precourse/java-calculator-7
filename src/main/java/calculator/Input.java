package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    static String input;
    static String[] tokens;
    public String inputCal(){
        input = Console.readLine();
        return input;
    }
    public String[] inputSplit(){
        tokens = input.split("[,:]");
        return tokens;
    }
    public int sumToken(){
        int sum = 0;
        for(String token : tokens){
            sum += Integer.parseInt(token);
        }
        return sum;
    }

}
