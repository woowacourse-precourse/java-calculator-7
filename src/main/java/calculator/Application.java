package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.Stream;

public class Application {
    int answer = 0;
    public static void main(String[] args) {
        System.out.println(new Application().calculator());
    }

    public String calculator(){
        String[] strs;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        //get splited String[]
        if(input.startsWith("//"))
            // custom
            strs = getStringArrayCostom(input);
        else
            // defualt 정규식!!
            strs = getStringArrayDefault(input);

        answer = getIntegerFromArray(strs);

        Console.close();
        return "결과 : "+String.valueOf(answer);
    }

    private String[] getStringArrayCostom(String input){
        return input.substring(5, input.length()).split("[,:"+String.valueOf(input.charAt(2))+"]");
    }

    private String[] getStringArrayDefault(String input){
        return input.split("[,:]");
    }
    private int getIntegerFromArray(String[] strs){
        //get int from String[]
        int answer = 0;
        for(String str : strs) {
            int v;
            try {
                v = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if(v<=0)
                throw new IllegalArgumentException();
            answer += v;
        }
        return answer;
    }
}